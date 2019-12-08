package com.taweesak.changeratefmrecyclerview.reclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ChangrateRecyclerviewAdapter extends RecyclerView.Adapter<ChangrateRecyclerviewAdapter.VH> {

    private Activity context;
    private ArrayList<Model> mDataList;
    private itemCallback mAdapterCallback;

    public ChangrateRecyclerviewAdapter(Activity context, ArrayList<Model> data, itemCallback adapterCallback) {
        this.context = context;
        this.mDataList = data;
        mAdapterCallback = adapterCallback;

    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Model s = mDataList.get(position);

        holder._name.setText(mDataList.get(position).getText());
        holder.itemView.setTag(position);

        holder.radioButton.setChecked(s.isChecked());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        RadioButton radioButton;
        TextView _name;


        public VH(View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.radio_button);
            _name = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickItem = (int) v.getTag();

                    //Toast.makeText(context,"item number : "+getAdapterPosition(),Toast.LENGTH_LONG).show();
                    //Toast.makeText(context,"item number : "+clickItem,Toast.LENGTH_LONG).show();
                    Toast.makeText(context,"item number : "+mDataList.get(clickItem).getText(),Toast.LENGTH_SHORT).show();


                    mAdapterCallback.itemCallback(getAdapterPosition());
                    notifyDataSetChanged();

                }
            });

        }
    }

    public interface itemCallback {
        //onItemClick handler
        void itemCallback(int position);
    }
}
