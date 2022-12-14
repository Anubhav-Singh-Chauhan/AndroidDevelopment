package com.example.notificationsconcept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String channel_id = "sample_channel";
    private static final int notification_id = 100;
    private static final int req_code = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.img,null);
        BitmapDrawable bitmap = (BitmapDrawable)drawable;
        Bitmap imgIcon = bitmap.getBitmap();
        Notification notification;

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent iNotify = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this,req_code,iNotify,PendingIntent.FLAG_UPDATE_CURRENT);

        //Big Picture Style

        Notification.BigPictureStyle bigStyle = new Notification.BigPictureStyle()
                .bigPicture(bitmap)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(imgIcon)
                    .setSmallIcon(R.drawable.img)
                    .setContentText("New Message")
                    .setSubText("New Message from XYZ")
                    .setChannelId(channel_id)
                    .setContentIntent(pi)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(channel_id,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            notification = new Notification.Builder(this)
                    .setLargeIcon(imgIcon)
                    .setSmallIcon(R.drawable.img)
                    .setContentText("New Message")
                    .setSubText("New Message from XYZ")
                    .setContentIntent(pi)
                    .build();
        }

        nm.notify(notification_id,notification);

    }
}