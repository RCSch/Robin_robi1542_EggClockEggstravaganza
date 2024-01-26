package com.example.robin_robi1542_eggclockeggstravaganza;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClockAdapter extends RecyclerView.Adapter<ClockAdapter.ClockViewHolder> {

    private List<Clock> clocks;

    public ClockAdapter(List<Clock> clocks) {
        this.clocks = clocks;
    }

    @NonNull
    @Override
    public ClockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single clock item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clock_item, parent, false);
        return new ClockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClockViewHolder holder, int position) {
        // Bind the data to the ViewHolder
        Clock clock = clocks.get(position);
        holder.bind(clock);
    }

    @Override
    public int getItemCount() {
        return clocks.size();
    }

    static class ClockViewHolder extends RecyclerView.ViewHolder {

        public ClockViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Clock clock) {
            // Bind data to the ViewHolder
            // For example, set text in TextViews, etc.
        }
    }
}
