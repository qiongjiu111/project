package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.VH> {
    private List<Lutemon> items;
    public LutemonAdapter(List<Lutemon> items) { this.items = items; }
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lutemon, parent, false);
        return new VH(v);
    }
    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Lutemon l = items.get(pos);
        h.tv.setText(l.getStats());
        switch(l.getColor()){
            case "Green":  h.img.setImageResource(R.drawable.green_lutemon); break;
            case "Pink":   h.img.setImageResource(R.drawable.pink_lutemon);  break;
            case "Orange": h.img.setImageResource(R.drawable.orange_lutemon);break;
            case "Black":  h.img.setImageResource(R.drawable.black_lutemon); break;
            default:       h.img.setImageResource(R.drawable.white_lutemon);
        }
    }
    @Override public int getItemCount(){ return items.size(); }
    public void updateData(List<Lutemon> data){ this.items = data; notifyDataSetChanged(); }
    static class VH extends RecyclerView.ViewHolder {
        ImageView img; TextView tv;
        VH(@NonNull View v){
            super(v);
            img = v.findViewById(R.id.imgLutemon);
            tv  = v.findViewById(R.id.tvStats);
        }
    }
}
