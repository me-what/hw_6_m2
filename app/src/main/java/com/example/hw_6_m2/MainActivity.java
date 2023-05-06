package com.example.hw_6_m2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.button);


        findViewById(R.id.button).setOnClickListener(view -> {
            if (editText.getText().toString().length() > 0){
                button.setBackgroundColor(getResources().getColor(R.color.orange));
            }
            else {
                button.setBackgroundColor(getResources().getColor(R.color.gray));
            }

            if (editText.getText().toString().equals("admin") && password.getText().toString().
                    equals("admin")){

                findViewById(R.id.email).setVisibility(View.GONE);
                findViewById(R.id.password).setVisibility(View.GONE);
                findViewById(R.id.button).setVisibility(View.GONE);
                findViewById(R.id.signin).setVisibility(View.GONE);
                findViewById(R.id.forgot).setVisibility(View.GONE);
                findViewById(R.id.click).setVisibility(View.GONE);
                Toast toast = Toast.makeText(getApplicationContext(),"вы зарегистрировались",
                        Toast.LENGTH_SHORT);
                toast.show();
            }else {
                Toast toast = Toast.makeText(getApplicationContext(), "неверный логин или пароль",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}