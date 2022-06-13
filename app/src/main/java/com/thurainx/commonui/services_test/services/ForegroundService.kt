package com.thurainx.commonui.services_test.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.thurainx.commonui.MainActivity
import com.thurainx.commonui.R
import com.thurainx.commonui.services_test.ServiceActivity

const val MESSAGE_KEY = "MESSAGE_KEY"
const val OWN_CHANNEL = "OWN_CHANNEL"
class ForegroundService : Service(){

    companion object{
        fun startService(context: Context,message: String) {
            val intent = Intent(context,ForegroundService::class.java)
            intent.putExtra(MESSAGE_KEY,message)
            ContextCompat.startForegroundService(context,intent)
        }

        fun stopService(context: Context){
            val intent = Intent(context,ForegroundService::class.java)
            context.stopService(intent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val message : String = intent?.getStringExtra(MESSAGE_KEY) ?: ""

        val notiIntent = Intent(this, ServiceActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,notiIntent,0)

        buildNotification()
        val notification = NotificationCompat.Builder(this, OWN_CHANNEL)
            .setContentTitle("Notification Title")
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_noti_outline)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        return START_NOT_STICKY
    }

    private fun buildNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(OWN_CHANNEL,"Notification Channel", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }



    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}