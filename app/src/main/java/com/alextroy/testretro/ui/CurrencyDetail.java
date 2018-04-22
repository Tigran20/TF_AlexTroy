package com.alextroy.testretro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.alextroy.testretro.R;

public class CurrencyDetail extends AppCompatActivity {

    private Button exchangeBtn;
    private TextView firstCurr;
    private TextView secondCurr;

    private String currencyName;
    private double currencyRate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail);

        firstCurr = findViewById(R.id.currency_name);
        secondCurr = findViewById(R.id.currency_name_2);

        Intent intent = getIntent();
        currencyName = intent.getStringExtra("currency_name");
        secondCurr.setText(currencyName.toUpperCase());

        exchangeBtn = findViewById(R.id.exchange_btn);
        exchangeBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent2);
        });

    }
}
