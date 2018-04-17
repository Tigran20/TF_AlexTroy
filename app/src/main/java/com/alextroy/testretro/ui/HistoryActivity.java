package com.alextroy.testretro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.alextroy.testretro.R;
import com.alextroy.testretro.adapter.HistoryAdapter;
import com.alextroy.testretro.model.Currency;
import com.alextroy.testretro.model.Rates;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Rates rates;
    private DrawerLayout drawerLayout;
    private static final String KEY = "a449de2a9b582986de1c3ee42bb6eb7f";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_history);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("История");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_dehaze_white_24dp);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        rates = new Rates();
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new HistoryAdapter(getApplicationContext(), rates.getCurrencyList());
        layoutManager = new LinearLayoutManager(HistoryActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        performRequest();
    }

    private void performRequest() {
        App.getApi().getCurrency(KEY).enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                adapter = new HistoryAdapter(getApplicationContext(), rates.getCurrencyList());
                Toast.makeText(HistoryActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(HistoryActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.main:
                            Intent intent0 = new Intent(getApplicationContext(), CurrencyListActivity.class);
                            startActivity(intent0);
                            break;
                        case R.id.history:
                            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.exchange:
                            Intent intent2 = new Intent(getApplicationContext(), HistoryActivity.class);
                            startActivity(intent2);
                            break;
                        case R.id.analitics:
                            Intent intent3 = new Intent(getApplicationContext(), HistoryActivity.class);
                            startActivity(intent3);
                            break;
                    }
                    return true;
                });
    }
}
