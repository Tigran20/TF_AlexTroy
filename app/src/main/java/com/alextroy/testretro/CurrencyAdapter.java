package com.alextroy.testretro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private List<Currency> currencies;
    private Context context;

    public CurrencyAdapter(Context context, List<Currency> currencies) {
        this.context = context;
        this.currencies = currencies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(currencies.get(position).getName());
        holder.rateTextView.setText(Double.toString(currencies.get(position).getRate()));
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView rateTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.currency_title);
            rateTextView = itemView.findViewById(R.id.currency_rate);

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
