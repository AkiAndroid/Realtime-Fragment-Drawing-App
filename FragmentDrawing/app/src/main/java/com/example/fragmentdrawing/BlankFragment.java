package com.example.fragmentdrawing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class BlankFragment extends Fragment {

    public BlankFragment(){
        reciever=new PathDataSender() {
            @Override
            public void ToSendPath(ArrayList<SinglePathStorage> DrawnPathStorage, Path path, int id) {
                DrawCanvas.setPaintPath(path);
                DrawCanvas.setPathData(DrawnPathStorage);
                DrawCanvas.invalidate();

            }
        };
    }

    PathDataSender reciever,sender;
    public int id=1;
    Canvas DrawCanvas;
    MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);







    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= new Canvas(getContext(), MainActivity.Receiver, id);
        DrawCanvas=(Canvas) view;
        return view;
    }
    public PathDataSender getReciever(){
        return reciever;

    }
}