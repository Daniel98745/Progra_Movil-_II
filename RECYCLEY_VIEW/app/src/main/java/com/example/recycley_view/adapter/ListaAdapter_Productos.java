package com.example.recycley_view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycley_view.R;
import com.example.recycley_view.model.Productos;

import java.util.ArrayList;

public class ListaAdapter_Productos extends RecyclerView.Adapter<ListaAdapter_Productos.listaProductoViewHolder> {

    ArrayList<Productos> listaProductos;

    public ListaAdapter_Productos(ArrayList<Productos> listaProductos){
        this.listaProductos = listaProductos;
    }

    //onCreateViewHolder CONEXION CON NUESTRA INTERFAZ
    @NonNull
    @Override
    public ListaAdapter_Productos.listaProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_productos, null,false);
        return new listaProductoViewHolder(view);
    }

    //onBindViewHolder CONEXION CON LA CLASE CLIENTES Y MIS IDENTIFICADORES
    @Override
    public void onBindViewHolder(@NonNull ListaAdapter_Productos.listaProductoViewHolder holder, int position) {
        holder.tvN.setText(listaProductos.get(position).getNombre());
        holder.tvP.setText(String.valueOf(listaProductos.get(position).getPrecio()));
        holder.tvD.setText(listaProductos.get(position).getDescripcion());
    }

    //getItemCount EL TAMANO DE LA LISTA CLIENTES
    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    //LA CONEXION O EL PUENTE ENTRE EL XML O LA CLASE R.
    public class listaProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvN,tvP,tvD;
        public listaProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvN = itemView.findViewById(R.id.txtNombre);
            tvP = itemView.findViewById(R.id.txtPrecio);
            tvD = itemView.findViewById(R.id.txtDescripcion);
        }
    }
}
