// Program Liczenie funkcji Kwadratowej

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {
    //deklaracja zmiennych widoku
    private EditText editA;
    private EditText editB;
    private EditText editC;
    private TextView x1;
    private TextView x2;
    private Button calculate;

    //metoda liczaca funkcje kwadratowa z podanych a,b,c
    protected void funkcjaKwadratowa(){
        int a = Integer.parseInt(editA.getText().toString());
        int b = Integer.parseInt(editB.getText().toString());
        int c = Integer.parseInt(editC.getText().toString());

        //wyliczenie delty z podanych a b c
        float delta = (b*b)-(4*a*c);
        if(delta>0) {
            double result_x1=(-b-sqrt(delta))/(2*a);
            double result_x2=(-b+sqrt(delta))/(2*a);
            x1.setText(String.valueOf(result_x1));
            x2.setText(String.valueOf(result_x2));
        }
        if(delta==0) {
            double result=-b/(2*a);
            x1.setText(String.valueOf(result));
        }
        if(delta<0) {
            String result = "brak";
            x1.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //powiazanie zmiennych z widokiem
        editA = (EditText)findViewById(R.id.edit_a);
        editB = (EditText)findViewById(R.id.edit_b);
        editC = (EditText)findViewById(R.id.edit_c);
        x1 = (TextView)findViewById(R.id.result_x1);
        x2 = (TextView)findViewById(R.id.result_x2);
        calculate = (Button)findViewById(R.id.calculate);

        //przy nacisnieciu buttona wywoluje sie metoda funkcjaKwadratowa
        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                funkcjaKwadratowa();
            }
        });
    }
}