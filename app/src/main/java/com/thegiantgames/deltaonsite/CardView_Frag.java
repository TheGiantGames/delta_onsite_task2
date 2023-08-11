package com.thegiantgames.deltaonsite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardView_Frag extends Fragment {

  FragViewModel model;
CardView cardView;
TextView textView;

    public CardView_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_view_, container, false);

        textView = view.findViewById(R.id.text);
        cardView = view.findViewById(R.id.cardView);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(FragViewModel.class);
        //model.setTextSize(48);
        model.getTextSize().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setTextSize(integer);
            }
        });

        model.getColor().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setTextColor(getResources().getColor(integer));
               //cardView.setCardBackgroundColor(getResources().getColor(integer));

            }
        });

        model.getBg_Color().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                cardView.setCardBackgroundColor(getResources().getColor(integer));
            }
        });

    }
}