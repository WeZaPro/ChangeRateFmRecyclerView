package com.taweesak.changeratefmrecyclerview.viewModel;

import com.taweesak.changeratefmrecyclerview.dataModel.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<Model> mString = new MutableLiveData<>();

    public void setmString(Model s) {
        mString.setValue(s);
    }

    public LiveData<Model> getmString() {
        return mString;
    }
}
