package com.example.listaview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lp;
    private TextView tvR;
    private EditText txtP;
    private Button btnA;
    private EditText txtPobla;
    ArrayList<String> paises;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> habitantes;
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
        cargarR();
        listarPaises();
        agregarPais();
    }
    public void cargarR(){
        lp = (ListView) findViewById(R.id.listaPaises);
        tvR = (TextView) findViewById(R.id.tvResu);
        txtP = (EditText) findViewById(R.id.txtPais);
        btnA = (Button) findViewById(R.id.btnAgregar);
        txtPobla = (EditText) findViewById(R.id.txtPobla);
    }

    public void listarPaises(){
        //ArrayList
        //String [] paises= {"Bolivia","Peru","Argentina","Chile","Paraguay","Brasil","Venezuela","Ecuador","Colombia"};
        paises = new ArrayList<String>();
        paises.add("bolivia");
        habitantes = new ArrayList<String>();
        habitantes.add("54648");
        //String [] habitantes= {"259583","122321","532425","103876","435677","234568","987765","987432","876594"};

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,paises);
        lp.setAdapter(arrayAdapter);
        lp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "la poblacion de : "+lp.getItemAtPosition(position)+" es de : "+habitantes[position], Toast.LENGTH_SHORT).show();
                //tvR.setText("la poblacion de : "+lp.getItemAtPosition(position)+" es de "+habitantes[position]);
                tvR.setText("la poblacion de : "+lp.getItemAtPosition(position)+" es de "+habitantes.get(position));
            }
        });
    }
    public void agregarPais(){
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //paises.add("bolivia");
                paises.add(txtP.getText().toString());
                lp.setAdapter(arrayAdapter);
                //para agregar habitantes en un editText
                habitantes.add(txtPobla.getText().toString());
                lp.setAdapter(arrayAdapter);
            }
        });
    }

}