package com.taweesak.changeratefmrecyclerview.reclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ChangrateRecyclerviewAdapter extends RecyclerView.Adapter<ChangrateRecyclerviewAdapter.VH> {

    private Context context;
    private ArrayList<Model> mDataList;

    public ChangrateRecyclerviewAdapter(Context context, ArrayList<Model> mDataList) {
        this.context = context;
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder._name.setText(mDataList.get(position).getText());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        TextView _name;

        public VH(View itemView) {
            super(itemView);

            _name = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickItem = (int) view.getTag();
                    Toast.makeText(context,"item number : "+clickItem,Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
