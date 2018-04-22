package com.alextroy.testretro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alextroy.testretro.R;
import com.alextroy.testretro.model.Currency;
import com.alextroy.testretro.ui.CurrencyDetail;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private List<Currency> currencies;
    private Context context;

    public CurrencyAdapter(Context context, List<Currency> currencies) {
        this.context = context;
        this.currencies = currencies;
//        this.currencyItemClickListener = currencyItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(currencies.get(position).getName());
        holder.favoritesImageView.setImageResource(R.drawable.ic_favorite_border_black_24dp);

    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public ImageView favoritesImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.currency_title);
            favoritesImageView = itemView.findViewById(R.id.currency_favorites);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), CurrencyDetail.class);
                intent.putExtra("currency_name", currencies.get(getAdapterPosition()).getName());
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
