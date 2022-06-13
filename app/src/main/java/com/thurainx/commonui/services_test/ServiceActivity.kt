package com.thurainx.commonui.services_test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.thurainx.commonui.R
import com.thurainx.commonui.services_test.intent_services.DownloadIntentService
import com.thurainx.commonui.services_test.job_intent_service.DownloadJobIntentService
import com.thurainx.commonui.services_test.services.ForegroundService
import com.thurainx.commonui.services_test.worker.DownloadWorker
import com.thurainx.commonui.services_test.worker.WORKER_IMAGE_URL
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context, ServiceActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        /* Service */
        btnStartForeground.setOnClickListener {
            ForegroundService.startService(this,"Service Testing")
        }
        btnStopForegorund.setOnClickListener {
            ForegroundService.stopService(this)
        }

        /* Intent Service */
        btnDownloadImage.setOnClickListener {
            DownloadIntentService.startIntentService(this,"https://storage.googleapis.com/gweb-uniblog-publish-prod/images/HeroHomepage_2880x1200.max-1300x1300.jpg")
        }

        /* Job Intent Service */
        btnJobIntentDownload.setOnClickListener {
            DownloadJobIntentService.startJobIntentService(this,"https://storage.googleapis.com/gweb-uniblog-publish-prod/images/HeroHomepage_2880x1200.max-1300x1300.jpg")
        }

        /* Work Manager */
        btnWorkManagerDownload.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .build()

            val inputData = Data.Builder()
                .putString(WORKER_IMAGE_URL,"https://storage.googleapis.com/gweb-uniblog-publish-prod/images/HeroHomepage_2880x1200.max-1300x1300.jpg")
                .build()

            val workRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
                .setInputData(inputData)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(this).enqueue(workRequest)

        }
    }
}