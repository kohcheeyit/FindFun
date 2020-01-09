package com.example.findfun

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat


class MyAlarmReceiver: BroadcastReceiver() {
    override  fun onReceive(context: Context, intent: Intent){
        val mBuilder = NotificationCompat.Builder(context!!)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Alarm Manager")
            .setContentText(intent.getStringExtra(EXTRA_PESAN))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        val v = longArrayOf(500,1000)
        mBuilder.setVibrate(v)

        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        mBuilder.setSound(uri)

        val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = 30103;
        mNotificationManager.notify(id,mBuilder.build())
    }
}
