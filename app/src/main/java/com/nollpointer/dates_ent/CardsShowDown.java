package com.nollpointer.dates_ent;


import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CardsShowDown extends Fragment {
    private Cursor crs;
    private int[] position, bound;
    private int type,mPick;

    private int getPick() {
        return mPick;
    }

    private void setPick(int pick) {
        mPick = pick;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards_show_down, container, false);
        MainActivity mAc = (MainActivity) getActivity();
        mAc.getSupportActionBar().hide();
        //mAc.setTheme(R.style.CardsShowDownStyle);
        final TextView textView = view.findViewById(R.id.date_cards_text);
        mAc.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        crs = mAc.getCursor();
        setRandom();
        textView.setText(crs.getString(getPick()));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,45);
        view.findViewById(R.id.cards_next_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,45);
                setRandom();
                textView.setText(crs.getString(mPick));
            }
        });
        view.findViewById(R.id.cards_description_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(crs.getString(0) + "\n" + crs.getString(1));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);
            }
        });
        return view;
    }

    public CardsShowDown setCenturies(ArrayList<Integer> arrayList,int T,int mode){
        type = T;
        if(mode ==0) {
            if (arrayList.contains(9))
                for (int i = 0; i < 9; i++)
                    arrayList.add(i, i);
            arrayList.remove(Integer.valueOf(9));
            Log.wtf("ASDASDA",arrayList.size() + "");
            position = new int[arrayList.size()];
            bound = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                switch (arrayList.get(i)) {
                    case 0:
                        position[i] = 0;
                        bound[i] = 51;
                        break;
                    case 1:
                        position[i] = 51;
                        bound[i] = 65;
                        break;
                    case 2:
                        position[i] = 116;
                        bound[i] = 57;
                        break;
                    case 3:
                        position[i] = 173;
                        bound[i] = 74;
                        break;
                    case 4:
                        position[i] = 247;
                        bound[i] = 60;
                        break;
                    case 5:
                        position[i] = 307;
                        bound[i] = 66;
                        break;
                    case 6:
                        position[i] = 373;
                        bound[i] = 73;
                        break;
                    case 7:
                        position[i] = 436;
                        bound[i] = 40;
                        break;
                    case 8:
                        position[i] = 476;
                        bound[i] = 39;
                        break;
                }
            }
        }else{
            if (arrayList.contains(6))
                for (int i = 0; i < 6; i++)
                    arrayList.add(i, i);
            arrayList.remove(Integer.valueOf(6));
            position = new int[arrayList.size()];
            bound = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                switch (arrayList.get(i)) {
                    case 0:
                        position[i] = 0;
                        bound[i] = 50;
                        break;
                    case 1:
                        position[i] = 50;
                        bound[i] = 33;
                        break;
                    case 2:
                        position[i] = 83;
                        bound[i] = 58;
                        break;
                    case 3:
                        position[i] = 141;
                        bound[i] = 41;
                        break;
                    case 4:
                        position[i] = 182;
                        bound[i] = 32;
                        break;
                    case 5:
                        position[i] = 214;
                        bound[i] = 64;
                        break;
                }
            }
        }
        return this;
    }
    public void setRandom(){
        Random rnd = new Random();
        int x = rnd.nextInt(position.length);
        crs.moveToPosition(position[x] + rnd.nextInt(bound[x]));
        switch (type){
            case 0:
                setPick(0);
                break;
            case 1:
                setPick(1);
                break;
            default:
                setPick(rnd.nextInt(10) > 4 ? 1 : 0);
        }
    }
}
