package com.example.taras.homeworklesson11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private String fragmentTag = Constants.DEFAULT_TAG;
    private MovementFragment movementFragment;
    private DrawingFragment drawingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.empty_string));

        movementFragment = new MovementFragment();
        drawingFragment = new DrawingFragment();

        startDrawingFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (!fragmentTag.equals(Constants.DRAWING_FRAGMENT_TAG)) {
            startDrawingFragment();
        } else {
            startMovementFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    private void startDrawingFragment() {
        fragmentTag = Constants.DRAWING_FRAGMENT_TAG;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.v_container_AM, drawingFragment)
                .commitAllowingStateLoss();
    }

    private void startMovementFragment() {
        fragmentTag = Constants.MOVEMENT_FRAGMENT_TAG;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.v_container_AM, movementFragment)
                .commitAllowingStateLoss();
    }
}
