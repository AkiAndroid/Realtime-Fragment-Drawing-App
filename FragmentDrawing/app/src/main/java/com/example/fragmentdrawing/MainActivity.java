package com.example.fragmentdrawing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.graphics.Path;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PathDataSender receiver1;
    PathDataSender receiver2;
    public static PathDataSender Receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Receiver=new PathDataSender() {
            @Override
            public void ToSendPath(ArrayList<SinglePathStorage> DrawnPathStorage, Path path, int id) {

                if (id==1){
                    receiver2.ToSendPath(DrawnPathStorage,path,id);
                }
                else {
                    receiver1.ToSendPath(DrawnPathStorage,path,id);

                }

            }
        };
        setContentView(R.layout.activity_main);



        //receiver1 = ((BlankFragment) getSupportFragmentManager().findFragmentById(R.id.firstLayout)).getReciever();
        BlankFragment firstFragment= new BlankFragment();
        receiver1= firstFragment.getReciever();
        FragmentManager manager= getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.firstLayout,firstFragment,firstFragment.getTag())
                .commit();


        //receiver2= ((SecondFragment) getSupportFragmentManager().findFragmentById(R.id.secondLayout)).getReciever();
        SecondFragment secondFragment= new SecondFragment();
        receiver2= secondFragment.getReciever();
        FragmentManager manager2= getSupportFragmentManager();
        manager2.beginTransaction()
                .replace(R.id.secondLayout,secondFragment,firstFragment.getTag())
                .commit();













    }


}