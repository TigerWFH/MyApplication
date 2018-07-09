package com.example.monkey.myapplication;

/**
 * Created by wangfanghua on 2018/1/18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.content.Intent;

public class Dashboard extends Fragment implements OnClickListener{
    public static Dashboard newInstance(String info) {
        Bundle args = new Bundle();
        Dashboard fragment = new Dashboard();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_view, null);
        TextView tvInfo = (TextView) view.findViewById(R.id.mkText);
        tvInfo.setText(getArguments().getString("info"));
        tvInfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Don't click me.please!.", Snackbar.LENGTH_SHORT).show();
            }
        });
        Button btn = view.findViewById(R.id.mkToPaper);
        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ChildDashboard.class);
        startActivity(intent);
    }
}
