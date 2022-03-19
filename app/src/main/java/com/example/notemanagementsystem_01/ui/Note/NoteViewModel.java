package com.example.notemanagementsystem_01.ui.Note;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NoteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}