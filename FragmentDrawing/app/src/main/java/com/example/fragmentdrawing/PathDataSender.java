package com.example.fragmentdrawing;

import android.graphics.Path;
import android.util.Log;

import java.util.ArrayList;

public interface PathDataSender {
    void ToSendPath(ArrayList<SinglePathStorage> DrawnPathStorage, Path path,int id);

}
