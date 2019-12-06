package com.taweesak.changeratefmrecyclerview.ui;


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
import android.widget.EditText;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;
import com.taweesak.changeratefmrecyclerview.dataModel.Model;
import com.taweesak.changeratefmrecyclerview.viewModel.ViewModel;

public class ChoiceFragment extends Fragment implements View.OnClickListener {

    Button buttonChoiceFragment;
    Fragment mainFragment;
    EditText editText;
    Model model;
    ViewModel viewModel;

    public ChoiceFragment() {
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
        View view = inflater.inflate(R.layout.fragment_choice, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = view.findViewById(R.id.editTextChoice);
        buttonChoiceFragment = view.findViewById(R.id.buttonChoiceFragment);
        buttonChoiceFragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String s = editText.getText().toString();
        model = new Model(s);
        viewModel.setmString(model);

        mainFragment = new MainFragment();
        replaceFragment(mainFragment);

    }

    private void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contentContainer_main, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
