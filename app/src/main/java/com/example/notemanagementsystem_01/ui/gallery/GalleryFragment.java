package com.example.notemanagementsystem_01.ui.gallery;


import android.app.Activity;
import android.app.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;
import androidx.room.Room;


import com.example.notemanagementsystem_01.R;
import com.example.notemanagementsystem_01.adapter.CatelogyAdapter;
import com.example.notemanagementsystem_01.database.CatelogyDatabase;
import com.example.notemanagementsystem_01.model.Catelogy;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class GalleryFragment extends Fragment {
    RecyclerView rcvCatelogy;
    FloatingActionButton floatingActionButton;
    private CatelogyAdapter catelogyAdapter;
    private List<Catelogy> listCatelogy;
    EditText edtNameCatelogy;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        return view;
    }

        public void onStart(){
        super.onStart();
        floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        rcvCatelogy = (RecyclerView) getActivity().findViewById(R.id.rcv_catelogy);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_Catelogy();
            }
        });

//        catelogyAdapter = new CatelogyAdapter();
//        listCatelogy = new ArrayList<>();
//        catelogyAdapter.SetData(listCatelogy);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        rcvCatelogy.setLayoutManager(linearLayoutManager);
//
//        rcvCatelogy.setAdapter(catelogyAdapter);


    }

    private void Dialog_Catelogy(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_catelogy);
        //ánh xạ
        EditText edtNameCatelogy = (EditText) getActivity().findViewById(R.id.EditTextNameCatelogy);
        Button btnAdd = (Button)   dialog.findViewById(R.id.ButtonAddCatelogy);
        Button   btnCancel     = (Button)   dialog.findViewById(R.id.ButtonCancel);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chưa fix được
                //AddCatelogy();
                Toast.makeText(getActivity(), "AAAAAAAAAAAAAAA", Toast.LENGTH_SHORT).show();
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

    private void AddCatelogy() {
        String strTen = edtNameCatelogy.getText().toString().trim();

        if(TextUtils.isEmpty(strTen)){
            return;
        }

        Catelogy catelogy = new Catelogy(strTen);

        // ap vao database
        CatelogyDatabase.getInstance(getActivity()).catelogyDAO().insertCatelogy(catelogy);

        edtNameCatelogy.setText("");
        listCatelogy = CatelogyDatabase.getInstance(getActivity()).catelogyDAO().getListCatelogy();
        catelogyAdapter.SetData(listCatelogy);

    }
}