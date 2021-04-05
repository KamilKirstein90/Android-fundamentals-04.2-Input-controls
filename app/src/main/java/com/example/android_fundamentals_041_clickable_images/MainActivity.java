package com.example.android_fundamentals_041_clickable_images;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Shows a message that one of the desserts images was clicked
     * The message depends on the image that is clicked and the text is stored in the strings.xml
     * @param view
     */

    public void takeOrder(View view){

        String message;

        switch (view.getId())
        {
            case R.id.iV_donut:
                message = getString(R.string.donut_order_message);
                break;
            case R.id.iV_ice_cream:
                message = getString(R.string.ice_cream_order_message);
                break;
            case R.id.iV_froyo:
                message = getString((R.string.froyo_order_message));
                break;
            default:
                message = "No order taken";
        }

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}