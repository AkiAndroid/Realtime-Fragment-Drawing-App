package com.example.fragmentdrawing;

import android.graphics.Path;

public class SinglePathStorage {

    public SinglePathStorage(Path _path, int color) {
        this._path = _path;
        Color = color;
    }

    Path _path;
    int Color;

}
