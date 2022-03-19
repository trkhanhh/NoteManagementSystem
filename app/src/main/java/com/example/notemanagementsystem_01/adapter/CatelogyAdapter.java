package com.example.notemanagementsystem_01.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem_01.R;
import com.example.notemanagementsystem_01.model.Catelogy;

import java.util.List;

public class CatelogyAdapter extends RecyclerView.Adapter<CatelogyAdapter.CatelogyViewHolder>{


    private List<Catelogy> listCatelogy;

    public void SetData(List<Catelogy> list){
        this.listCatelogy = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CatelogyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catelogy, parent,false);
        return new CatelogyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatelogyViewHolder holder, int position) {
        Catelogy catelogy = listCatelogy.get(position);
        if(catelogy == null){
            return;
        }
        holder.txtNameCatelogy.setText(catelogy.getTenCtl());
       // holder.txtDateClt.setText(catelogy.getTenCtl());
    }

    @Override
    public int getItemCount() {
        if(listCatelogy != null){
            return listCatelogy.size();
        }
        return 0;
    }

    public class  CatelogyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNameCatelogy;

        public CatelogyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameCatelogy = itemView.findViewById(R.id.TextViewNameCategory);
        }
    }


}
