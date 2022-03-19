package com.example.notemanagementsystem_01.ui.slideshow;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notemanagementsystem_01.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SlideshowFragment extends Fragment {

    FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        return view;
    }
    public void onStart(){
        super.onStart();
        floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_Priority();
            }
        });
    }

    private void Dialog_Priority(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_priority);
        //ánh xạ
        Button btnAdd = (Button)   dialog.findViewById(R.id.ButtonAddPriority);
        Button   btnCancel     = (Button)   dialog.findViewById(R.id.ButtonCancelPriority);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

}