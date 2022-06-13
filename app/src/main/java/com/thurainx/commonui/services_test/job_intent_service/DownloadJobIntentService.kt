package com.thurainx.commonui.services_test.job_intent_service

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.core.app.JobIntentService
import com.thurainx.commonui.services_test.intent_services.DOWNLOAD_IMAGE_URL
import java.io.File

class DownloadJobIntentService : JobIntentService(){

    companion object{
        fun startJobIntentService(context: Context,url: String){
            val jobId = 10
            val intent = Intent(context, DownloadJobIntentService::class.java)
            intent.putExtra(DOWNLOAD_IMAGE_URL,url)
            enqueueWork(context,DownloadJobIntentService::class.java,jobId,intent)
        }
    }
    override fun onHandleWork(intent: Intent) {
        try {
            val url = intent.getStringExtra(DOWNLOAD_IMAGE_URL)
            url?.let {
                downloadImage(url = url)
            }
        }catch (e  : Exception){
            stopSelf()
        }
    }


    private fun downloadImage(fileName : String = "${System.currentTimeMillis()}.jpg", url: String){
        try {
            val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            val uri = Uri.parse(url)
            val request = DownloadManager.Request(uri)

            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                .setTitle("Download Image")
                .setAllowedOverRoaming(false)
                .setMimeType("image/jpeg")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    File.separator + fileName
                )

            dm.enqueue(request)
            Toast.makeText(this,"Download Start", Toast.LENGTH_SHORT).show()

        }catch (e : Exception){
            Toast.makeText(this,"Download Fail", Toast.LENGTH_SHORT).show()

        }

    }


}