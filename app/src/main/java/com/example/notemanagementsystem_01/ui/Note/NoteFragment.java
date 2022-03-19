package com.example.notemanagementsystem_01.ui.Note;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notemanagementsystem_01.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NoteFragment extends Fragment {

    Button btnDate;
    TextView txtDate;
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
                Dialog_Note();
            }
        });
    }

    private void Dialog_Note(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_note);
        //ánh xạ
        Button btnAdd = (Button)   dialog.findViewById(R.id.ButtonAddNote);
        Button   btnCancel     = (Button)   dialog.findViewById(R.id.ButtonCancelNote);
        btnDate = dialog.findViewById(R.id.ButtonDate);
        txtDate = dialog.findViewById(R.id.TextViewDate);
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

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });

        dialog.show();
    }



    private void ChonNgay(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,day);
        datePickerDialog.show();
    }

}