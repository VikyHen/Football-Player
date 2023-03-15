package com.if4a.footballplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFootballPlayer extends RecyclerView.Adapter<AdapterFootballPlayer.ViewHolder> {
    private Context ctx;
    private ArrayList arrNama, arrNomor, arrKlub;

    public AdapterFootballPlayer(Context ctx, ArrayList arrNama, ArrayList arrNomor, ArrayList arrKlub) {
        this.ctx = ctx;
        this.arrNama = arrNama;
        this.arrNomor = arrNomor;
        this.arrKlub = arrKlub;
    }

    @NonNull
    @Override
    public AdapterFootballPlayer.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_player, parent, false);
        return new ViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFootballPlayer.ViewHolder holder, int position) {
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvNomor.setText(arrNomor.get(position).toString());
        holder.tvKlub.setText(arrKlub.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvNomor, tvKlub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvNomor = itemView.findViewById(R.id.tv_nomor);
            tvKlub = itemView.findViewById(R.id.tv_klub);
        }
    }
}
