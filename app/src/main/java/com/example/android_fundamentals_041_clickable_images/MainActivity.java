package com.example.android_fundamentals_041_clickable_images;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_ORDER_MESSAGE_MAIN_ACT = "MainActivity.extra.mOrderMessage";
    private String mOrderMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Act2.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Shows a message that one of the desserts images was clicked
     * The message depends on the image that is clicked and the text is stored in the strings.xml
     * @param view
     */

    public void takeOrder(View view){

        switch (view.getId())
        {
            case R.id.iV_donut:
                mOrderMessage = getString(R.string.donut_order_message);
                break;
            case R.id.iV_ice_cream:
                mOrderMessage = getString(R.string.ice_cream_order_message);
                break;
            case R.id.iV_froyo:
                mOrderMessage = getString((R.string.froyo_order_message));
                break;
            default:
                mOrderMessage = "No order taken";
        }
        startAct2WithOrder(EXTRA_ORDER_MESSAGE_MAIN_ACT, mOrderMessage);
    }

    /**
     * this method pass a string to an intent and then starts a new activity with the extra put in that intent.
     *
     * @param message pass a string to the second activity
     * @param key with the right key to get it from the bunlde in the second activity
     */

    private void startAct2WithOrder(String key, String message){

        Intent intent = new Intent (MainActivity.this, Act2.class);
        intent.putExtra(key,message);
        startActivity(intent);
    }
}