package com.troy.saferadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Home fragment = new Home();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram, fragment);
        transaction.commit();
    }


    private void addNotification() {
        // Builds your notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Test")
                .setContentText("TEEEEEEESSSSSSSSST");

        // Creates the intent needed to show the notification
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
    public void openmenu(View view) {
        final ResideMenu resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.cc);
        resideMenu.attachToActivity(this);
        resideMenu.setScaleValue(0.6f);
        resideMenu.setShadowVisible(false);



        ResideMenuItem itemHome     = new ResideMenuItem(this, R.drawable.ic_home_black_24dp,     "Home");
        ResideMenuItem itemorders     = new ResideMenuItem(this, R.drawable.ic_perm_contact_calendar_black_24dp,     "Orders");
        ResideMenuItem itemclose  = new ResideMenuItem(this, R.drawable.ic_close_black_24dp,  "Close");




        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemorders, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemclose, ResideMenu.DIRECTION_RIGHT);



        itemHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Home fragment = new Home();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fram, fragment);
                transaction.commit();

            }
        });


        itemorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Orders fragment = new Orders();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fram, fragment);
                transaction.commit();

            }
        });


        itemclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.closeMenu();

            }
        });
        resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);
    }

}
