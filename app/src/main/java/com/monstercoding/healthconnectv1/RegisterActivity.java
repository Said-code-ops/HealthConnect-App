package com.monstercoding.healthconnectv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView have_account_login=findViewById(R.id.have_account_login);
        have_account_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        CheckBox checkBox=findViewById(R.id.checkbox_register);
        checkBox.setButtonTintList(ContextCompat.getColorStateList(RegisterActivity.this,R.color.checkbox_color));

        getOnBackPressedDispatcher().addCallback(RegisterActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                startActivity(new Intent(RegisterActivity.this,SignInOrSignUp.class));
                finish();

                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

        AppCompatButton register_btn=findViewById(R.id.register_btn);
        Animation clickAnimation= AnimationUtils.loadAnimation(RegisterActivity.this,R.anim.button_click_animation);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);

                register_btn.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    }
                },200);
            }
        });
    }
}