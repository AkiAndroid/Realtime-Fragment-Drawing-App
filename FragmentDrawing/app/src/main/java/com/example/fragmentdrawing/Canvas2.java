package com.example.fragmentdrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Canvas2 extends View  {
    public static float xPos,yPos;

    Paint red;
    Path path;

    List<Path> toDrawPath= new ArrayList<Path>();

    public Canvas2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

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
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xpos,ypos);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }
        invalidate();
        return true;




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i=0;i<toDrawPath.size();i++){

            canvas.drawPath(toDrawPath.get(i),red);
        }


    }





}
