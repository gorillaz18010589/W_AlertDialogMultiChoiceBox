package com.example.alertdialogmultichoicebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btn1(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Warning");
        alert.setMessage("Do you want to delete it ");

        alert.setPositiveButton("yse", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you press Yes", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you press No", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alert.create();
        alert.show();
    }

    public void btn2(View view) {
        final String[] color = {"Red","Blue","Yellow"};
        AlertDialog.Builder alert2 = new AlertDialog.Builder(MainActivity.this);
        alert2.setTitle("Pick color").setItems(color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,color[which],Toast.LENGTH_SHORT).show();
                Log.v("which:" , "" +which);
            }
        });

        alert2.show();
    }

    public void btn3(View view) {
        AlertDialog.Builder alert3 = new AlertDialog.Builder(MainActivity.this);
        final CharSequence[] color = {"Red", "Blue", "Yellow"};
        final ArrayList mselected = new ArrayList();
        alert3.setTitle("選擇按鈕")
                .setMultiChoiceItems(color, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.v("hank", "which:" + which + "isChecked:" + isChecked);
                        if (isChecked) {
                            mselected.add(which);
                            Toast.makeText(MainActivity.this,color[which],Toast.LENGTH_SHORT).show();
                        } else if (mselected.contains(which)) {
                            mselected.remove(which);
                        }
                    }
                });

        alert3.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i <= mselected.size(); i++) {
                    Toast.makeText(MainActivity.this, color[i], Toast.LENGTH_SHORT).show();
                    Log.v("hank","i:" + i);
                }
            }
        });

        alert3.show();
    }
}
