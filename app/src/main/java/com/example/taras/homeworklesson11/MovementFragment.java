package com.example.taras.homeworklesson11;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MovementFragment extends Fragment implements View.OnTouchListener, View.OnClickListener {
    private RelativeLayout relativeLayout;
    private Button btnButton, btnImage, btnText;
    private RelativeLayout.LayoutParams layoutParams;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movement, container, false);
        setRetainInstance(true);

        layoutParams = new RelativeLayout.LayoutParams(100, 100);
        initViews(view);
        setOnClickListeners();

        return view;
    }

    private void setOnClickListeners() {
        btnButton.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnText.setOnClickListener(this);
    }

    private void initViews(View view) {
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_moving_area_FM);
        btnButton = (Button) view.findViewById(R.id.btn_button_FM);
        btnImage = (Button) view.findViewById(R.id.btn_image_FM);
        btnText = (Button) view.findViewById(R.id.btn_text_FM);
    }

    @Override
    public void onClick(View v) {
        relativeLayout.removeAllViews();

        switch (v.getId()) {
            case R.id.btn_button_FM :
                createButtonView();
                break;

            case R.id.btn_image_FM :
                createImageView();
                break;

            case R.id.btn_text_FM :
                createTextView();
                break;
        }
    }

    private void createTextView() {
        TextView textView = new TextView(getActivity());
        textView.setText(getResources().getString(R.string.text));
        textView.setClickable(true);
        textView.setTextSize(Constants.TEXT_SIZE);
        textView.setTextColor(Color.CYAN);
        relativeLayout.addView(textView);
        textView.setOnTouchListener(this);
    }

    private void createImageView() {
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.drawable.ic_ball);
        imageView.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        imageView.setOnTouchListener(this);
    }

    private void createButtonView() {
        Button button = new Button(getActivity());
        button.setText(getResources().getString(R.string.button));
        relativeLayout.addView(button);
        button.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_MOVE) {
            return true;
        }

        // if you read this, then all my attempts to make view move under your fingers was unsuccessful
        // so I decided to calibrate options to my testing device Asus Google Nexus 7 (2012)

        view.setX(event.getRawX() - Constants.SHIFT_X - view.getWidth() / 2);
        view.setY(event.getRawY() - Constants.SHIFT_Y - view.getHeight() / 2);

        relativeLayout.invalidate();
        return true;
    }
}
