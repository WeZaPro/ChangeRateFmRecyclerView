package com.taweesak.changeratefmrecyclerview.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;
import com.taweesak.changeratefmrecyclerview.reclerview.ChangrateRecyclerviewAdapter;
import com.taweesak.changeratefmrecyclerview.viewModel.ViewModel;

import java.util.ArrayList;

public class RvFragment extends Fragment implements ChangrateRecyclerviewAdapter.itemCallback{

    private Context context;
    private ArrayList<Model> lstData = new ArrayList<>();
    RecyclerView recyclerView;
    private ChangrateRecyclerviewAdapter mAdapter;
    ViewModel viewModel;
    Button buttonSelectChoice;

    public RvFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(ViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rv, container, false);

        data();

        buttonSelectChoice = view.findViewById(R.id.sendChoice);
        recyclerView = view.findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChangrateRecyclerviewAdapter(getActivity(),lstData,this);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         buttonSelectChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change fragment to main fragment ******************
                MainFragment mainFragment = new MainFragment();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.contentContainer_main,mainFragment).commit();
            }
        });

    }

    private void data() {
        String name_[] = {"Kitty 1","Kitty 2","Kitty 3","Kitty 4","Kitty 5","Kitty 6","Kitty 7","Kitty 8"};
        int image[] = {R.drawable.usa,R.drawable.japan,R.drawable.europe,R.drawable.usa,R.drawable.japan,
                R.drawable.europe,R.drawable.usa,R.drawable.japan,};

        int dataSize = name_.length;

        for (int i = 0; i <dataSize ; i++) {
            Model model = new Model(name_[i],image[i]);
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
