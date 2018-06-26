package com.example.android.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    int score;
    int languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.English:
                if (checked) {
                    languages += 1;
                    checked=false;
                } else

                    break;
            case R.id.German:
                if (checked) {
                    languages += 1;
                    checked=false;
                } else
                    break;

            case R.id.French:
                if (checked) {
                    languages += 1;
                    checked=false;
                } else
                    break;
        }
        }

    public void finish(View view) {
        // Is the button now checked?
        //boolean checked = ((RadioButton) view).isChecked();
        RadioButton like = findViewById(R.id.radio_Like);
        RadioButton does = findViewById(R.id.radio_does);
        RadioButton wantsBreakfast = findViewById(R.id.radio_wantsBreakfast);
        RadioButton isDay = findViewById(R.id.radio_isDay);
        EditText nameText=findViewById(R.id.username);
        name =nameText.getText().toString();

        if (like.isChecked() == true) {
            // Add to the score
            score += 1;
        }
        if (does.isChecked() == true) {
            // Add to the score
            score += 1;
        }
        if (wantsBreakfast.isChecked() == true) {
            // Add to the score
            score += 1;
        }
        if (isDay.isChecked() == true) {
            // Add to the score
            score += 1;
        }
//        Toast toast = Toast.makeText(getApplicationContext(), "Your score is "+score, Toast.LENGTH_SHORT);
//        toast.show();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
        a_builder.setMessage("Hi " + name + " Your Score is: " + score+" \n And you know "+languages+" Languages!!")
                .setCancelable(false)
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score = 0;
                        Intent mIntent = getIntent();
                        finish();
                        startActivity(mIntent);
                    }
                })
                .setNegativeButton("Close App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score = 0;
                        languages=0;
                        finish();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Score !!!");
        alert.show();
    }

}
