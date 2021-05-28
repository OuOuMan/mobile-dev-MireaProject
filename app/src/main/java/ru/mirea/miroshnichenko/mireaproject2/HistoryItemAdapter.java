package ru.mirea.miroshnichenko.mireaproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryItemAdapter  extends RecyclerView.Adapter<HistoryItemAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<HistoryItem> states;

    HistoryItemAdapter(Context context, List<HistoryItem> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public HistoryItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.history_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryItemAdapter.ViewHolder holder, int position) {
        HistoryItem state = states.get(position);
        holder.nameView.setText(state.title);
        holder.capitalView.setText(state.text);
        holder.hashTagView.setText("#" + state.hashtag);
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, capitalView, hashTagView;

        ViewHolder(View view) {
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            capitalView = (TextView) view.findViewById(R.id.capital);
            hashTagView = (TextView) view.findViewById(R.id.hashTagViw);
        }
    }

}