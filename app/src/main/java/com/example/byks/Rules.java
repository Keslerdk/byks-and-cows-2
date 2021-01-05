package com.example.byks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Rules extends AppCompatActivity {
    TextView rule;
    TextView example;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        rule = (TextView) findViewById(R.id.textView10);
        rule.setText("Компьютер «задумывает» четырехзначное число, не содержащее двух одинаковых цифр! Вы" +
                "набираете свое число, и компьютер сообщает количество правильных (точно угаданных цифр, т.е.," +
                "стоящих на своих местах) и неправильных цифр (цифр, которые есть в задуманном числе, но на другом месте).");
        rule.setTextSize(22);
        example = (TextView) findViewById(R.id.textView14);
        example.setText("Например, пусть задуманное число 5734, а вы набирали 0755. Результат будет 1 правильный и 2 неправильных." +
                "Игра продолжается до тех пор, пока вы получите 4 правильных.");
        example.setTextSize(22);
    }
    public void Begin(View view) {
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }
}