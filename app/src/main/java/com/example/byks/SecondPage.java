package com.example.byks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {
    private Number cell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
    }

    public void onClick(View view) {
//        EditText form = (EditText) findViewById(R.id.editTextNumber);
        TextView text=(TextView) findViewById(R.id.textView5);
        text.setText("Hello Kitty!");
    }
    //не работает.
    /*
    public void MakeCell(View view) {
        LinearLayout linearLayout =  (LinearLayout) findViewById(R.id.linearlayout);

        // Create a EditText
        EditText editText = new EditText(this);
        editText.setHint("Subject");
        linearLayout.addView(editText);

        // Set Text
        editText.setText("Some Text");

        // Get Text
        String text = editText.getText().toString();
    } */

}