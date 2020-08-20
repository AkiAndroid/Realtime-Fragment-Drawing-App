package com.example.fragmentdrawing;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import  android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Canvas extends View {

    Paint red;
    Path path;

    PathDataSender dataListener;
    int fragid;

    ArrayList<SinglePathStorage> PathDrawnData;


    public Canvas(Context context, PathDataSender dataListener, int fragid) {
        super(context);
        this.dataListener = dataListener;
        this.fragid = fragid;

        PathDrawnData=new ArrayList<>();


        red=new Paint();
        path=new Path();
        red.setAntiAlias(true);
        red.setColor(Color.RED);
        red.setStrokeJoin(Paint.Join.ROUND);
        red.setStyle(Paint.Style.STROKE);
        red.setStrokeWidth(10f);

    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xpos = event.getX();
        float ypos = event.getY();


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xpos,ypos);
                MainActivity.Receiver.ToSendPath(PathDrawnData,path,fragid);

                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xpos,ypos);
                MainActivity.Receiver.ToSendPath(PathDrawnData,path,fragid);
                break;

            case MotionEvent.ACTION_UP:
                PathDrawnData.add(new SinglePathStorage(path,Color.RED));
                path=new Path();
                break;

            default:
                return false;
        }
        invalidate();
        return true;




    }


    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);

        for (int i=0; i<PathDrawnData.size();i++){
            canvas.drawPath(PathDrawnData.get(i)._path,red);
        }
        canvas.drawPath(path,red);

    }

    public void setPaintPath(Path path){
        this.path=path;
        invalidate();
    }

    public void setPathData(ArrayList<SinglePathStorage> pathData){
        PathDrawnData=pathData;
        invalidate();
    }
}
