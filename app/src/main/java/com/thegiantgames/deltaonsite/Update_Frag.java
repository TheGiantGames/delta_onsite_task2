package com.thegiantgames.deltaonsite;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Update_Frag extends Fragment {

    FragViewModel model;
    SeekBar seekBar;
    Spinner spinner, bg_spinner;

    public Update_Frag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update_, container, false);
        model =  new ViewModelProvider(requireActivity()).get(FragViewModel.class);
        seekBar = view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                model.setTextSize(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ArrayList<Integer> colId = new ArrayList<>();
        colId.add(R.color.black);
        colId.add(R.color.green);
        colId.add(R.color.blue);
        colId.add(R.color.skyblue);
        colId.add(R.color.red);
        colId.add(R.color.violet);
        colId.add(R.color.orange);
        colId.add(R.color.gray);
        colId.add(R.color.pink);
        colId.add(R.color.white);
        colId.add(R.color.yellow);
       // colId.add(getResources().getColor(R.color.green));
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Black");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Sky Blue");
        colors.add("Red");
        colors.add("Violet");
        colors.add("Orange");
        colors.add("Gray");
        colors.add("Pink");
        colors.add("White");
        colors.add("Yellow");


        ArrayList<Integer> bgColorId = new ArrayList<>();
        bgColorId.add(R.color.light_blue);
        bgColorId.add(R.color.light_skyblue);
        bgColorId.add(R.color.light_red);
        bgColorId.add(R.color.light_purple);
        bgColorId.add(R.color.light_green);
        bgColorId.add(R.color.light_pink);
        bgColorId.add(R.color.light_yellow);


        ArrayList<String> bgColors = new ArrayList<>();
        bgColors.add("blue");
        bgColors.add("sky blue");
        bgColors.add("red");
        bgColors.add("purple");
        bgColors.add("green");
        bgColors.add("pink");
        bgColors.add("yellow");


        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("color" , "" + colId.get(position));
                model.setColor(colId.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter bgAdaptor = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, bgColors);
        bgAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bg_spinner = view.findViewById(R.id.bg_spinner);
        bg_spinner.setAdapter(bgAdaptor);
        bg_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model.setBg_color(bgColorId.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}