package com.example.time3.DBASE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.time3.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context c;
    ArrayList<Subject> players;

    RelativeLayout expandedLay;
    ImageView icDownarrow,icUparrow;
    MaterialCardView cardView;

    public ItemAdapter(Context c, ArrayList<Subject> players) {
        this.c = c;
        this.players = players;

    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null)
        {
           view= LayoutInflater.from(c).inflate(R.layout.item_layout,null);
        }

        TextView timetxt = (TextView) view.findViewById(R.id.timetxt);
        TextView codetxt = (TextView) view.findViewById(R.id.codetxt);
        TextView moduletxt = (TextView) view.findViewById(R.id.moduletxt);
        TextView stafftxt = (TextView) view.findViewById(R.id.stafftxt);



        Subject player=(Subject) this.getItem(i);

        timetxt.setText(player.getTime());
        codetxt.setText(player.getCode());
        moduletxt.setText(player.getModule());
        stafftxt.setText(player.getStaff());




      icDownarrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if (expandedLay.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandedLay.setVisibility(View.VISIBLE);
                    icDownarrow.setVisibility(View.GONE);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandedLay.setVisibility(View.GONE);
                }
            }
        });



        return view;
    }
}
