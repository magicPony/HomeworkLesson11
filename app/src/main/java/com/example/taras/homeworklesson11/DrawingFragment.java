package com.example.taras.homeworklesson11;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DrawingFragment extends Fragment implements View.OnClickListener {
    private int colorBlack, colorBlue, colorRed;
    private DrawingView drawingView;
    private View vBlackColor, vBlueColor, vRedColor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawing, container, false);
        setRetainInstance(true);

        initViews(view);
        setOnClickListeners();
        drawingView = (DrawingView) view.findViewById(R.id.dv_drawing_area);
        initColors();

        return view;
    }

    private void setOnClickListeners() {
        vBlackColor.setOnClickListener(this);
        vBlueColor.setOnClickListener(this);
        vRedColor.setOnClickListener(this);
    }

    private void initViews(View view) {
        vBlackColor = view.findViewById(R.id.v_black_FD);
        vBlueColor = view.findViewById(R.id.v_blue_FD);
        vRedColor = view.findViewById(R.id.v_red_FD);
    }

    private void initColors() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            colorBlack = getContext().getColor(R.color.colorBlack);
            colorBlue = getContext().getColor(R.color.colorBlue);
            colorRed = getContext().getColor(R.color.colorRed);
        } else {
            colorBlack = getContext().getResources().getColor(R.color.colorBlack);
            colorBlue = getContext().getResources().getColor(R.color.colorBlue);
            colorRed = getContext().getResources().getColor(R.color.colorRed);
        }

        drawingView.setPaintColor(colorBlack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.v_black_FD :
                drawingView.setPaintColor(colorBlack);
                break;

            case R.id.v_blue_FD :
                drawingView.setPaintColor(colorBlue);
                break;

            case R.id.v_red_FD :
                drawingView.setPaintColor(colorRed);
                break;
        }
    }
}
