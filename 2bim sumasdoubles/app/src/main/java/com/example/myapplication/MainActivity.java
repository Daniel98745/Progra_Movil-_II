package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.clases.Operaciones;

public class MainActivity extends AppCompatActivity {
Operaciones operaciones;
EditText txt1,txt2;
TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   int s=2;
    //    float f=2.4f;
    //    float res=(float)s+f;  //castiung de datod
        //parseo de datos como en c#
        txt1 = (EditText) findViewById(R.id.txt1);//los textos de activityMain
        txt2 = (EditText) findViewById(R.id.txt2);//los textos de activityMain
        txtresult = (TextView) findViewById(R.id.txtresult);//los textos de activityMain

    }

    public void sumar(View view){//para el boton suma, el primer View te aparece en rojo solamente importas su clase
//metodo asignando una variable y lugo se parsea
      /*  String val1=txt1.getText().toString();//ha llegado a operaciones
        String val2=txt2.getText().toString();
        int n1=Integer.parseInt(val1);//esto si llea a operaciones
        int n2=Integer.parseInt(val2);//esto si llea a operaciones*/

        //forma abreviadfa
        double n1 = Double.parseDouble(txt1.getText().toString()); // Esto sí llega a operaciones
        double n2 = Double.parseDouble(txt2.getText().toString());//esto si llea a operaciones
        operaciones = new Operaciones(n1,n2);//val1 y2  vienen en cadena hay que parsearlo a int
        txtresult.setText(String.valueOf(operaciones.suma()));
       // System.out.print("la suma es::::"+operaciones.suma());
    }




}