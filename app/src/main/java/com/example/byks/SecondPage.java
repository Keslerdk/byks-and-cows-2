package com.example.byks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {
    private LinearLayout vertical;
    private EditText editText;
    private Button button;
    private Button otvet;
    //    private TextView otvet;
    generation chislo = new generation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_second_page);
        setContentView(R.layout.cell);

        vertical = (LinearLayout) findViewById(R.id.vertical);
        editText = (EditText) findViewById(R.id.editTextNumber2);
        editText.setHint("4х-значное");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(Result());
        otvet = (Button) findViewById(R.id.button5);
        otvet.setOnClickListener(Answer());
//        otvet=(TextView) findViewById(R.id.textView10);
//        otvet.setText(Integer.toString(x.x));

//        generation();
    }

    private View.OnClickListener Result() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                if (Proverka(editText.getText().toString())) {
                    Numbers();
                }
//                layout2.addView(Numbers(Integer.toString(x)));
            }
        };
    }

    public void Reststart(View v) {
        //....
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }

    private View.OnClickListener Answer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondPage.this);
                builder.setTitle("Ответ")
                        .setMessage(Integer.toString(chislo.array[0]*1000+chislo.array[1]*100+chislo.array[2]*10+chislo.array[3]))
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        };
    }

    private boolean Proverka(String text) {
        if (text.length() != 4) return false;
        else return true;

    }
    public void Hint(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SecondPage.this);
        builder.setTitle("Подсказка")
                .setMessage(chislo.Hint())
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void Numbers() {
        LinearLayout horizon = new LinearLayout(this);
        horizon.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams hparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        horizon.setLayoutParams(hparams);
        vertical.addView(horizon);
        //...
        TextView currentNumber = new TextView(this);
        final LinearLayout.LayoutParams tparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//       tparams.leftMargin=50;
        currentNumber.setLayoutParams(tparams);
        currentNumber.setText("Ваше число: " + editText.getText().toString());
        currentNumber.setTextSize(20);
        horizon.addView(currentNumber);
        //...
        TextView guess = new TextView(this);
        final LinearLayout.LayoutParams gparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        gparams.leftMargin = 170;
//       gparams.gravity = Gravity.LEFT;
        guess.setLayoutParams(gparams);
        if (chislo.guess(editText.getText().toString())!="Вы угадали!") guess.setText(chislo.guess(editText.getText().toString()));
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(SecondPage.this);
            builder.setTitle("Вы угадали!")
                    .setMessage("Молодец!")
                    .setCancelable(false)
                    .setPositiveButton("Попробовать еще раз",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(SecondPage.this, SecondPage.class);
                                    startActivity(intent);
                                    dialog.cancel();
                                }
                            });
            builder.setNegativeButton("Выход", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1); }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        guess.setTextSize(20);
        horizon.addView(guess);
    }

}