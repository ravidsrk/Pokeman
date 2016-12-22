package com.suhaas.pokeman.ui.detail;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.suhaas.pokeman.R;
import com.suhaas.pokeman.data.model.Stats;

import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.ViewHolder>{

    public List<Stats> statsList;
    private Context mContext;

    public StatsAdapter(Context context, List<Stats> feedResultList) {
        this.statsList = feedResultList;
        this.mContext = context;
    }

    @Override
    public StatsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_detail, parent, false);
        return new StatsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatsAdapter.ViewHolder holder, int position) {
        Stats stats = statsList.get(position);
        holder.pokemanText.setText(stats.getStat().getName());
        holder.progressBar.setProgress(stats.getBaseStat());
    }

    @Override
    public int getItemCount() {
        return statsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pokemanText;
        private ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            pokemanText = (TextView) itemView.findViewById(R.id.pokemanText);
            progressBar = (ProgressBar) itemView.findViewById(R.id.statsProgress);
        }
    }
}
