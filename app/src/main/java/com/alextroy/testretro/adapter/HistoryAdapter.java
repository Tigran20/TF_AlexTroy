package com.alextroy.testretro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alextroy.testretro.R;
import com.alextroy.testretro.model.Currency;
import com.alextroy.testretro.ui.CurrencyDetail;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<Currency> currencies;
    private Context context;

    public HistoryAdapter(Context context, List<Currency> currencies) {
        this.context = context;
        this.currencies = currencies;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        HistoryAdapter.ViewHolder viewHolder = new HistoryAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        holder.firstCurrencyTextView.setText("USD");
        holder.secondCurrencyTextView.setText("RUB");
        holder.dateCurrencyTextView.setText("10.04.2018");
        //        holder.dateCurrencyTextView.setText(currencies.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstCurrencyTextView;
        public TextView secondCurrencyTextView;
        public TextView dateCurrencyTextView;


        public ViewHolder(View itemView) {
            super(itemView);

            firstCurrencyTextView = itemView.findViewById(R.id.currency_first);
            secondCurrencyTextView = itemView.findViewById(R.id.currency_second);
            dateCurrencyTextView = itemView.findViewById(R.id.currency_date);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), CurrencyDetail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            });
        }
    }

    public void removeItem(int position) {
        this.currencies.remove(position);
        super.notifyItemRemoved(position);
    }
}
