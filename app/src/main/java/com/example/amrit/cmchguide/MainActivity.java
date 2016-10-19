package com.example.amrit.cmchguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.amrit.cmchguide.Map.MapActivity;

public class MainActivity extends AppCompatActivity {

    String[] buildings;
    String[] xArray;
    String[] yArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildings = getResources().getStringArray(R.array.buildingsArray);
        xArray = getResources().getStringArray(R.array.xArray);
        yArray = getResources().getStringArray(R.array.yArray);
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra("name", buildings[0]);
        intent.putExtra("x", xArray[0]);
        intent.putExtra("y", yArray[0]);
        startActivity(intent);
    }

    public void gotoNew(View view) {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra("name", buildings[1]);
        intent.putExtra("x", xArray[1]);
        intent.putExtra("y", yArray[1]);
        startActivity(intent);
    }

    public void gotoCafe(View view) {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra("name", buildings[2]);
        intent.putExtra("x", xArray[2]);
        intent.putExtra("y", yArray[2]);
        startActivity(intent);
    }

    public void gotoMedical(View view) {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra("name", buildings[3]);
        intent.putExtra("x", xArray[3]);
        intent.putExtra("y", yArray[3]);
        startActivity(intent);
    }

    public void gotoNursing(View view) {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra("name", buildings[4]);
        intent.putExtra("x", xArray[4]);
        intent.putExtra("y", yArray[4]);startActivity(intent);
    }

    public void gotoDental(View view) {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra("name", buildings[5]);
        intent.putExtra("x", xArray[5]);
        intent.putExtra("y", yArray[5]);
        startActivity(intent);
    }

    private void toastIt(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
