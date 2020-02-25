package com.example.catalinaislandboatexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private int costPerTicket = 34;
    private int noOfTickets;
    private int totalPrice;
    private String spinnerValue;
    private DecimalFormat currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currency = new DecimalFormat("$###,###");
        final EditText input = findViewById(R.id.noOfTickets);
        final TextView result = findViewById(R.id.outputResult);
        final Spinner spinner = findViewById(R.id.spinner);
        final Button computeBtn = findViewById(R.id.computeButton);

        computeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ticketsEntered = input.getText().toString();
                noOfTickets = ticketsEntered.equals("") ? 0 : Integer.parseInt(ticketsEntered);
                totalPrice = noOfTickets * costPerTicket;
                spinnerValue = spinner.getSelectedItem().toString();
                result.setText("One Way Trip to " + spinnerValue + " - " + currency.format(totalPrice));

                // Hide the keyboard, if it is shown
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });
    }
}
