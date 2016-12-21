package com.suhaas.pokeman.data.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.suhaas.pokeman.R;
import com.suhaas.pokeman.data.model.list.Results;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    public List<Results> resultsArrayList;
    private Context mContext;

    public ListAdapter(Context context, List<Results> feedResultList) {
        this.resultsArrayList = feedResultList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_main, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Results results = resultsArrayList.get(position);
        holder.nameText.setText(results.getName());
    }

    @Override
    public int getItemCount() {
        return resultsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        public ViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.text_list_name);
        }
    }
}
