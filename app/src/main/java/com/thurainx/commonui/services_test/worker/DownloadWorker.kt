package com.thurainx.commonui.services_test.worker

import android.app.DownloadManager
import android.content.Context
import android.content.Context.DOWNLOAD_SERVICE
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.File

const val WORKER_IMAGE_URL = "WORKER_IMAGE_URL"
class DownloadWorker(val context: Context,params: WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {
        return try {
            val url = inputData.getString(WORKER_IMAGE_URL)
            url?.let {
                downloadImage(context = context, url = url)
            }
            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }

    private fun downloadImage(fileName : String = "${System.currentTimeMillis()}.jpg", url: String, context: Context){
        try {
            val dm =  context.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
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
            Toast.makeText(context,"Download Start", Toast.LENGTH_SHORT).show()

        }catch (e : Exception){
            Toast.makeText(context,"Download Fail", Toast.LENGTH_SHORT).show()

        }

    }

}