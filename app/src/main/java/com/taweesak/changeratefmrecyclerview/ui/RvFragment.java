package com.taweesak.changeratefmrecyclerview.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;
import com.taweesak.changeratefmrecyclerview.reclerview.ChangrateRecyclerviewAdapter;

import java.util.ArrayList;

public class RvFragment extends Fragment implements ChangrateRecyclerviewAdapter.itemCallback{

    private Context context;
    private ArrayList<Model> lstData = new ArrayList<>();
    RecyclerView recyclerView;
    private ChangrateRecyclerviewAdapter mAdapter;

    public RvFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rv, container, false);

        data();

        recyclerView = view.findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChangrateRecyclerviewAdapter(getActivity(),lstData,this);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void data() {
        String name_[] = {"Kitty 1","Kitty 2","Kitty 3","Kitty 4","Kitty 5","Kitty 6","Kitty 7"};

        int dataSize = name_.length;

        for (int i = 0; i <dataSize ; i++) {
            Model model = new Model(name_[i]);
            lstData.add(model);
        }
    }

    @Override
    public void itemCallback(int position) {

        Model p = lstData.get(position);
        p.setChecked(true);
        for (int x = 0; x < lstData.size(); x++) {
            Model ship = lstData.get(x);
            if (x != position) {
                ship.setChecked(false);
            }
        }

        mAdapter.notifyDataSetChanged();
        recyclerView.refreshDrawableState();

       // Toast.makeText(getActivity(), p.getUnit() + " is selected", Toast.LENGTH_SHORT).show();

    }
}
