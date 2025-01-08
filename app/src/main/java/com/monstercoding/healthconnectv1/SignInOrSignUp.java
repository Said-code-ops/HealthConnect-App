package com.monstercoding.healthconnectv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInOrSignUp extends AppCompatActivity {

    AppCompatButton SignIn,SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sign_in_or_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SignIn=findViewById(R.id.sign_in_btn);
        SignUp=findViewById(R.id.sign_up_btn);


        Animation clickAnimation= AnimationUtils.loadAnimation(SignInOrSignUp.this,R.anim.button_click_animation);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.startAnimation(clickAnimation);

                //start activity after animation

                SignIn.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SignInOrSignUp.this, LoginActivity.class));

                        //Add transition animation

                        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                    }
                },200);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);

                SignUp.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SignInOrSignUp.this, RegisterActivity.class));

                        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                    }
                },200);
            }
        });
    }
}