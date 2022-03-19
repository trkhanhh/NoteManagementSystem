package com.example.notemanagementsystem_01.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.notemanagementsystem_01.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    String[] mucDo = {"Pending","Processing","Done"};
    int[] hoanThanh = {20 , 60, 20};
    private HomeViewModel homeViewModel;
    AnyChartView anyChartView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        anyChartView = root.findViewById(R.id.AnychartView);
        setupPieChart();

        return root;
    }

    public void setupPieChart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for(int i = 0; i < mucDo.length; i++){
            dataEntries.add(new ValueDataEntry(mucDo[i], hoanThanh[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }
}