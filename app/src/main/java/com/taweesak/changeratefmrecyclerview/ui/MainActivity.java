package com.taweesak.changeratefmrecyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.taweesak.changeratefmrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    ChoiceFragment choiceFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callAFragment();
    }

    private void callAFragment() {
        mainFragment = new MainFragment();
        choiceFragment = new ChoiceFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.contentContainer_main,mainFragment)
                //.add(R.id.contentContainer_choice,choiceFragment)
                .commit();
        Toast.makeText(this,"Main",Toast.LENGTH_SHORT).show();

    }
}
