package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    private EditText cj1,cj2;
    private TextView tvResul;
    private Button btnOp;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        cargarR();
        cargarDataSpinner();
        estadoBoton();
    }

    public void cargarR(){
        cj1 = (EditText) findViewById(R.id.txt1);
        cj2 = (EditText) findViewById(R.id.txt2);
        tvResul = (TextView) findViewById(R.id.tvR);
        btnOp = (Button) findViewById(R.id.btnOperar);
        sp = (Spinner) findViewById(R.id.spOpe);
    }
    public void cargarDataSpinner(){
        String [] operaciones = {"suma", "resta", "multiplicacion", "division"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,operaciones);
        sp.setAdapter(arrayAdapter);
    }
    public void estadoBoton(){
        btnOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getSelectedItem().toString().equals("suma")){
                    tvResul.setText(String.valueOf(Integer.parseInt(cj1.getText().toString()) + Integer.parseInt(cj2.getText().toString())));
                } else if (sp.getSelectedItem().toString().equals("resta")){
                    tvResul.setText(String.valueOf(Integer.parseInt(cj1.getText().toString()) - Integer.parseInt(cj2.getText().toString())));
                } else if (sp.getSelectedItem().toString().equals("multiplicacion")) {
                    tvResul.setText(String.valueOf(Integer.parseInt(cj1.getText().toString()) * Integer.parseInt(cj2.getText().toString())));
                } else if (sp.getSelectedItem().toString().equals("division")) {
                    if (Integer.parseInt(cj2.getText().toString())!=0){
                        tvResul.setText(String.valueOf(Integer.parseInt(cj1.getText().toString()) / Integer.parseInt(cj2.getText().toString())));
                    }else{
                        tvResul.setText("error");
                    }
                }
            }
        });
    }
}