package io.citrus.bottomsheetexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior behaviour;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout bottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);

        b1.setOnClickListener(expandedOrCollapsed);
        b2.setOnClickListener(bottomSheetHide);

        behaviour = BottomSheetBehavior.from(bottomSheet);
        behaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    View.OnClickListener expandedOrCollapsed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(behaviour.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                behaviour.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                behaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }
    };

    View.OnClickListener bottomSheetHide = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (behaviour.getState() == BottomSheetBehavior.STATE_HIDDEN){
                behaviour.setHideable(false);
                behaviour.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                behaviour.setHideable(true);
                behaviour.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        }
    };
}
