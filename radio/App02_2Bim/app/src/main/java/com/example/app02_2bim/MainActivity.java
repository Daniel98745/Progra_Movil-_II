package com.example.app02_2bim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Inicializar las variables
    private EditText caja1, caja2;
    private TextView resultado;
    private RadioButton rbSuma,rbResta,rbMultiplicacion, rbDivision;
    private Button operar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        caja1 = (EditText) findViewById(R.id.txt1);
        caja2 = (EditText) findViewById(R.id.txt2);
        resultado = (TextView) findViewById(R.id.Resultado);
        rbSuma = (RadioButton) findViewById(R.id.rb1);
        rbResta = (RadioButton) findViewById(R.id.rb2);
        rbMultiplicacion = (RadioButton) findViewById(R.id.rb3);
        rbDivision = (RadioButton) findViewById(R.id.rb4);
        operar = (Button) findViewById(R.id.btnOperar);

        //Lanzar el metodo Onclick
        operar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = caja1.getText().toString();
                String val2 = caja2.getText().toString();
                Double num1 = Double.parseDouble(val1);
                Double num2 = Double.parseDouble(val2);
                double resul;
                if (rbSuma.isChecked() == true){
                    resul = num1 + num2;
                    String respuestaTexto = String.valueOf(resul);
                    resultado.setText(respuestaTexto);
                } else if (rbResta.isChecked() == true) {
                    resul = num1 - num2;
                    String respuestaTexto = String.valueOf(resul);
                    resultado.setText(respuestaTexto);
                } else if (rbMultiplicacion.isChecked() == true) {
                    resul = num1 * num2;
                    String respuestaTexto = String.valueOf(resul);
                    resultado.setText(respuestaTexto);
                } else if (rbDivision.isChecked() == true) {
                    if (num2 != 0 && num1>0){
                        resul = num1 / num2;
                        String respuestaTexto = String.valueOf(resul);
                        resultado.setText(respuestaTexto);
                    } else if (num2 == 0) {
                        Toast.makeText(MainActivity.this, "NO SE PUEDE", Toast.LENGTH_SHORT).show();
                        resultado.setText("eRROR");
                    }
                }
            }
        });
    }
}