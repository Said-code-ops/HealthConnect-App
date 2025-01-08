package com.monstercoding.healthconnectv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DoctorOnBoarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_on_boarding);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getOnBackPressedDispatcher().addCallback(DoctorOnBoarding.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                startActivity(new Intent(DoctorOnBoarding.this,LoginActivity.class));
                finish();

            }
        });

        Animation clickAnimation= AnimationUtils.loadAnimation(DoctorOnBoarding.this,R.anim.button_click_animation);
        Button doctors_onbording_btn=findViewById(R.id.getStart_bookDoc);
        doctors_onbording_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);

                doctors_onbording_btn.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                },200);
            }
        });
    }
}