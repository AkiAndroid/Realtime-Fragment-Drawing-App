package com.example.fragmentdrawing;

import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

    public SecondFragment(){
        receiver=new PathDataSender() {
            @Override
            public void ToSendPath(ArrayList<SinglePathStorage> DrawnPathStorage, Path path, int id) {
                DrawCanvas.setPaintPath(path);
                DrawCanvas.setPathData(DrawnPathStorage);
            }
        };
    }

    int id=2;
    PathDataSender receiver,sender;
    Canvas DrawCanvas;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View FragmentView= new Canvas(getContext(), MainActivity.Receiver, id);

        DrawCanvas=(Canvas) FragmentView;

        return FragmentView;
    }
    public PathDataSender getReciever(){
        return receiver;

    }

    }
