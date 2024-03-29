package com.taweesak.changeratefmrecyclerview.reclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;
import com.taweesak.changeratefmrecyclerview.ui.MainActivity;
import com.taweesak.changeratefmrecyclerview.ui.MainFragment;
import com.taweesak.changeratefmrecyclerview.ui.RvFragment;
import com.taweesak.changeratefmrecyclerview.viewModel.ViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class ChangrateRecyclerviewAdapter extends RecyclerView.Adapter<ChangrateRecyclerviewAdapter.VH> {

    private Activity context;
    private ArrayList<Model> mDataList;
    private itemCallback mAdapterCallback;
    private ViewModel viewModel;

    public ChangrateRecyclerviewAdapter(Activity context, ArrayList<Model> model, itemCallback adapterCallback) {
        this.context = context;
        this.mDataList = model;
        mAdapterCallback = adapterCallback;

        viewModel = ViewModelProviders.of((FragmentActivity) context).get(ViewModel.class);
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
        holder._imageFlag.setImageResource(mDataList.get(position).getImage());
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
        ImageView _imageFlag;

        public VH(View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.radio_button);
            _name = itemView.findViewById(R.id.tv_name);
            _imageFlag = itemView.findViewById(R.id.imageFlag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int clickItem = (int) v.getTag();

                    //Toast.makeText(context,"item number : "+mDataList.get(clickItem).getText(),Toast.LENGTH_SHORT).show();

                    updateCart(mDataList.get(clickItem));

                    // check data
                    //Toast.makeText(context,"BUNDEL to is : "+bundle,Toast.LENGTH_SHORT).show();
                    /*mAdapterCallback.itemCallback(getAdapterPosition());*/
                    mAdapterCallback.itemCallback(clickItem);
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface itemCallback {
        //onItemClick handler
        void itemCallback(int position);
    }

    private void updateCart(Model cartModel) {
        String txt = String.valueOf(cartModel.getText());
        int imageFlags = cartModel.getImage();
        Log.d(TAG, "updateText: " + txt);
        Log.d(TAG, "updateImage: " + imageFlags);
        /*cartRepository.updateCartRepo(cartModel);*/
        viewModel.setmString(cartModel);

    }

}
