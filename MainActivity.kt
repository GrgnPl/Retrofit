package com.example.dosyayukleme

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitkullanm.CRUDCevap
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class MainActivity : AppCompatActivity(),UploadRequestBody.UploadCallback {
    private var selectedImage:Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image_view.setOnClickListener{
            openImageChooser()
        }
        button_upload.setOnClickListener {
            uploadImage()
        }
    }

    private fun uploadImage()
    {
        if (selectedImage == null)
        {
            root.snackbar("Lütfen Fotoğraf Seçiniz !!!")
            return
        }
        val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedImage!!,"r",null)?:return
        val file = File(cacheDir,contentResolver.getFileName(selectedImage!!))
        val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
        val outputStream = FileOutputStream(file)
        inputStream.copyTo(outputStream)

        progress_bar.progress = 0
        val body  = UploadRequestBody(file,"image",this)
        MyApi().uploadImage(
            MultipartBody.Part.createFormData("image",file.name,body),
            RequestBody.create(MediaType.parse("Multipart/form-data"),"Bu cihazdan gönderildi")
        ).enqueue(object :retrofit2.Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                progress_bar.progress = 100
                root.snackbar(response.body()?.message.toString())

            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                root.snackbar(t.message!!)
            }

        })
    }
    private fun openImageChooser() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val i = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            i.addCategory(Intent.CATEGORY_DEFAULT)
            startActivityForResult(Intent.createChooser(i, "Choose directory"), 9999)
        }
        Intent(Intent.ACTION_PICK).also {
            it.type = "image/*"
            val mimeTypes = arrayOf("image/jpeg", "image/png")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            startActivityForResult(it,REQUEST_CODE_IMAGE_PİCKER)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_IMAGE_PİCKER -> {
                    selectedImage = data?.data
                    image_view.setImageURI(selectedImage)
                }
            }
            when (requestCode) {
                9999 -> Log.i("Test", "Result URI ")
            }
        }
    }
    companion object{
        private const val REQUEST_CODE_IMAGE_PİCKER =100
    }

    override fun onProgressUpdate(percentage: Int) {
        progress_bar.progress = percentage
    }

}