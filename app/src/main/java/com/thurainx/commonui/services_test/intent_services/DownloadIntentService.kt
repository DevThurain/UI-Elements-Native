package com.thurainx.commonui.services_test.intent_services

import android.app.DownloadManager
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import java.io.File

const val DOWNLOAD_IMAGE_URL = "DOWNLOAD_IMAGE_URL"
class DownloadIntentService : IntentService(DOWNLOAD_SERVICE) {

    companion object{
        fun startIntentService(context: Context,url: String){
            val intent = Intent(context, DownloadIntentService::class.java)
            intent.putExtra(DOWNLOAD_IMAGE_URL,url)
            context.startService(intent)
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            val url = intent?.getStringExtra(DOWNLOAD_IMAGE_URL)
            url?.let {
                downloadImage(url = url)
            }
        }catch (e  : Exception){
            stopSelf()
        }
    }

    override fun onDestroy() {
        Toast.makeText(this,"Service Destroy",Toast.LENGTH_SHORT).show()
        super.onDestroy()
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
            Toast.makeText(this,"Download Start",Toast.LENGTH_SHORT).show()

        }catch (e : Exception){
            Toast.makeText(this,"Download Fail",Toast.LENGTH_SHORT).show()

        }

    }
}