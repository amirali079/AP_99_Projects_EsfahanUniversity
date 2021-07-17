package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.mohammad_es_faz4_gui.BackEnd.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class CitiesActivity extends AppCompatActivity {

    private static Context thisStaticContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Objects.requireNonNull(getSupportActionBar()).hide();
        thisStaticContext = this;

        Button addCityBackBtu = findViewById(R.id.citiesBackButton);
        addCityBackBtu.setOnClickListener(view -> {
            onBackPressed();
        });

        FloatingActionButton addCityButton = findViewById(R.id.floatAddCityButton);
        addCityButton.setOnClickListener(view ->
            switchToAddCity()
        );
    }

    @Override
    public void onResume() {
        makeCitiesButton();
        super.onResume();
    }

    private void makeCitiesButton() {
        LinearLayout linearLayout = findViewById(R.id.citiesLinearLayout);
        for (int i = linearLayout.getChildCount(); i < MainActivity.myCountry.getCities().size(); i++) {
            Button cityButton = new Button(this);
            createButtonStyle(cityButton, MainActivity.myCountry.getCities().get(i).getName());
            int finalI = i;
            cityButton.setOnClickListener(v -> switchToCity(finalI));
            linearLayout.addView(cityButton);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public static void createButtonStyle(Button button, String text){
        buttonLayout(button);

        buttonColor(button);

        button.setText(text);
        button.setAllCaps(false);
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);

        button.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
                view.setBackgroundColor(Color.parseColor("#700390D1"));
            if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
                buttonColor((Button)view);
            return false;
        });
    }

    public static void buttonLayout(Button button){
        final float scale = thisStaticContext.getResources().getDisplayMetrics().density;
        int heightPixels = (int) (49 * scale + 0.5f);
        int widthPixels = (int) (255 * scale + 0.5f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthPixels, heightPixels);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins(0, 30 , 0 , 0);
        button.setLayoutParams(layoutParams);
    }

    public static void buttonColor(Button button){
        button.setTextColor(thisStaticContext.getResources().getColor(R.color.white));

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(thisStaticContext.getResources().getColor(R.color.purple_500));
        gd.setCornerRadius(10);
        gd.setStroke(2, Color.WHITE);
        button.setBackground(gd);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void switchToAddCity() {
        Intent switchActivityIntent = new Intent(this, AddCityActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchToCity(int cityIndex) {
        Intent switchActivityIntent = new Intent(this, CityActivity.class);
        switchActivityIntent.putExtra("cityIndex", cityIndex);
        startActivity(switchActivityIntent);
    }
}