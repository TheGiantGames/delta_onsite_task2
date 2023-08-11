package com.thegiantgames.deltaonsite;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragViewModel extends ViewModel {
    MutableLiveData<Integer> textSize = new MutableLiveData<>();
    public  void setTextSize(int value){
        textSize.setValue(value);
    }

    public LiveData<Integer> getTextSize(){
        return textSize;
    }

    MutableLiveData<Integer> color = new MutableLiveData<>();

    public void setColor(Integer  colorId){
        color.setValue(colorId);
    }

    public LiveData<Integer> getColor(){
        return color;
    }

    MutableLiveData<Integer> bg_color = new MutableLiveData<>();

    public void setBg_color(Integer  colorId){
        bg_color.setValue(colorId);
    }

    public LiveData<Integer> getBg_Color(){
        return bg_color;
    }
}
