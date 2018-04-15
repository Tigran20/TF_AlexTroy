package com.alextroy.testretro;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CurrencyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String KEY = "a449de2a9b582986de1c3ee42bb6eb7f";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_news);

        CurrencyExchange currencyExchange = new CurrencyExchange();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CurrencyAdapter(getApplicationContext(), currencyExchange.getCurrencyList());
        layoutManager = new LinearLayoutManager(CurrencyListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        SwipeController swipeController = new SwipeController(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);

//        performRequest();
    }

//    private void performRequest() {
//        App.getApi().getCurrency(KEY).enqueue(new Callback<CurrencyExchange>() {
//            @Override
//            public void onResponse(Call<CurrencyExchange> call, Response<CurrencyExchange> response) {
//                CurrencyExchange currencyExchange = response.body();
//                CurrencyAdapter adapter = new CurrencyAdapter(getApplicationContext(), currencyExchange.getCurrencyList());
//
//                recyclerView.setAdapter(adapter);
//
//                Toast.makeText(CurrencyListActivity.this, "Success", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<CurrencyExchange> call, Throwable t) {
//                Toast.makeText(CurrencyListActivity.this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_history:
                return true;
            case R.id.navigation_exchange:
                return true;
            case R.id.navigation_analytics:
                return true;
        }
        return false;
    };
}
