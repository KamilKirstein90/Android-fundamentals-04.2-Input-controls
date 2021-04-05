package com.example.android_fundamentals_041_clickable_images;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Act2 extends AppCompatActivity {

    private static final String SAVE_BUNDLE_ORDER_MESSAGE = "Act2.bundle.string.mOrderMessageFromAct1";
    private String mOrderMessageFromAct1;
    TextView tv_orderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        tv_orderMessage = findViewById(R.id.tV_orderMessage);
        // get the intent from MainAct
        if (savedInstanceState != null)
        {
            mOrderMessageFromAct1 = savedInstanceState.getString(SAVE_BUNDLE_ORDER_MESSAGE);

        }
        else
        {
            Intent intent = getIntent();
            mOrderMessageFromAct1 = intent.getStringExtra(MainActivity.EXTRA_ORDER_MESSAGE_MAIN_ACT);
        }

        // to prevent passing a null obj to the text view, this should not be a problem but to be sure
        if ( mOrderMessageFromAct1 == null)
                    mOrderMessageFromAct1 = "";

        tv_orderMessage.setText(mOrderMessageFromAct1);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVE_BUNDLE_ORDER_MESSAGE, mOrderMessageFromAct1);

    }

}