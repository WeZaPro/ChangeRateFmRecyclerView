package com.taweesak.changeratefmrecyclerview.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;
import com.taweesak.changeratefmrecyclerview.viewModel.ViewModel;

public class MainFragment extends Fragment implements View.OnClickListener {

    Button buttonMainFragment;
    Fragment choicefragment;
    ViewModel viewModel;
    TextView textView;
    Model model;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(requireActivity()).get(ViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.textViewMain);
        getDataFromViewModel();

        buttonMainFragment = view.findViewById(R.id.buttonMainFragment);
        buttonMainFragment.setOnClickListener(this);
    }

    private void getDataFromViewModel() {

        viewModel.getmString().observe(getActivity(), new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                Toast.makeText(getActivity(), "on main FM Text is : " + model.getText(), Toast.LENGTH_SHORT).show();
                textView.setText("" + model.getText());
            }
        });
    }

    @Override
    public void onClick(View view) {

        choicefragment = new ChoiceFragment();
        replaceFragment(choicefragment);
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contentContainer_main, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
