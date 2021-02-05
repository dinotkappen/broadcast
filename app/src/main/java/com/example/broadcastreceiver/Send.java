package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Send extends AppCompatActivity {
    public static final String ACTION_TEXT_CHANGED = "changed";
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        retrieveMessage("Dino");

        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void retrieveMessage(String message) {
        Intent intent = new Intent();
        intent.setAction(ACTION_TEXT_CHANGED);
        intent.putExtra("content", message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}