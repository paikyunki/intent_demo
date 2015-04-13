package com.example.yunki.save_instance_state_demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends Activity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }

    public void onProcess(View view) {
        Intent intent = null, chooser = null;

        if (R.id.btn_map == view.getId()) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.87777"));
            chooser = Intent.createChooser(intent, "Launch Map");
            startActivity(chooser);
        }

        if (R.id.btn_market == view.getId()) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.ksmobile.cb"));
            chooser = Intent.createChooser(intent, "Download from Market");
            startActivity(chooser);
        }

        if (R.id.btn_send_email == view.getId()) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"yunkipaik@gmail.com", "isaac@livermorehosting.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello, my first email from android!");
            intent.putExtra(Intent.EXTRA_TEXT, "This is supposed to be email message text");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("yunki", "counter=" + ++counter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d("yunki", "onSaveInstanceState " + counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d("yunki", "onRestoreInstanceState " + counter);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
