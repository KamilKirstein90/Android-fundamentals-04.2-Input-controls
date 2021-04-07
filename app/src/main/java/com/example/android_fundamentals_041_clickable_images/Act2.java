package com.example.android_fundamentals_041_clickable_images;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// a spinner is used in this activity and for it to react to the selection of it items a AdapterView.OnItemSelectedListener
// interface must be implemented and with it the two methods the onItemSelected and onNothingSelected

public class Act2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String SAVE_BUNDLE_ORDER_MESSAGE = "Act2.bundle.string.mOrderMessageFromAct1";
    private String mOrderMessageFromAct1;
    TextView tv_orderMessage;
    RadioButton rbNextDay;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        tv_orderMessage = findViewById(R.id.tV_orderMessage);
        rbNextDay = findViewById(R.id.rb_nextday);
         //initialize next day button
        rbNextDay.setChecked(true);

        // look for the spinner if not null set the onItemSeletedListeoner of this context to it

        spinner = findViewById(R.id.spinner);
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears. this is a already available layout from the android library for one spinner item

        if (spinner != null)
        {
            spinner.setOnItemSelectedListener(this);
            // the listener of this spinner is now this act2 and it can response to it in the onItemSelected method

            // set the adapter to it
            spinner.setAdapter(adapter);

        }



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

    public void onRadioButtonClicked(View view) {

        // for radio button the checked state has to be checked as well

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.rb_sameday:
                if(checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.rb_nextday:
                if(checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.rb_pickup:
                if(checked)
                    displayToast(getString(R.string.pick_up));
                break;
        }

    }

    /**
     * create an easier method for displaying tost messages
     * @param message
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel;
        spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}