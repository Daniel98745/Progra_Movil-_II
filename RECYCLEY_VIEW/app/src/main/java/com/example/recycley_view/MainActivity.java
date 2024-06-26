package com.example.recycley_view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycley_view.adapter.ListaAdapter_Productos;
import com.example.recycley_view.model.Productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText txtPRO;
    private EditText txtP;
    private EditText txtD;
    private Button btnA;
    RecyclerView listaRecyrcleyViewPersona;
    ArrayList<Productos> listaProductos = new ArrayList<Productos>();
    ListaAdapter_Productos listaAdapterProductos;

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
        cargadoListaProductos();
        agregarProductos();
    }

    public void cargarR(){
        listaRecyrcleyViewPersona = (RecyclerView) findViewById(R.id.listaR_Persona);
        txtPRO = (EditText) findViewById(R.id.tvNombre);
        txtP = (EditText) findViewById(R.id.tvPrecio);
        txtD = (EditText) findViewById(R.id.tvDescripcion);
        btnA = (Button) findViewById(R.id.btnAgregar);



    }
    public void cargadoListaProductos(){
        listaRecyrcleyViewPersona.setLayoutManager(new LinearLayoutManager(this));
        listaProductos.add(new Productos("Laptop",2500,"Computadora de escritorio"));
        listaProductos.add(new Productos("Laptop",2800,"Computadora de escritorio"));
        listaAdapterProductos = new ListaAdapter_Productos(listaProductos);
        listaRecyrcleyViewPersona.setAdapter(listaAdapterProductos);




        listaRecyrcleyViewPersona.setLayoutManager(new LinearLayoutManager(this));
        listaProductos.add(new Productos("Laptop",3000,"Compu de escritorio"));
        listaAdapterProductos = new ListaAdapter_Productos(listaProductos);
        listaRecyrcleyViewPersona.setAdapter(listaAdapterProductos);


    }
    public void agregarProductos(){
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtPRO.getText().toString();
                double precio = Double.parseDouble(txtP.getText().toString());
                String descripcion = txtD.getText().toString();
                listaProductos.add(new Productos(nombre,(int)precio,descripcion));
                listaRecyrcleyViewPersona.setAdapter(listaAdapterProductos);

                txtPRO.setText("");
                txtD.setText("");
                txtP.setText("");
            }
        });
    }
}