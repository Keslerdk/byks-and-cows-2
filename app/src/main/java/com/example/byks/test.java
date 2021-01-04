package com.example.byks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;


public class test extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(test.this);
        builder.setTitle("Важное сообщение!")
                .setMessage("Закройте окно!")
                .setCancelable(false)
                .setNegativeButton("ОК, иду на балкон",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
