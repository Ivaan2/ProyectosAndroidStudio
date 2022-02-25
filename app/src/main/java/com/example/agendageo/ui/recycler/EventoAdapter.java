package com.example.agendageo.ui.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendageo.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder>{

    public List<Evento> listaEventos;
    private LayoutInflater mInflater;

    public EventoAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.vista_evento, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(listaEventos != null){
            holder.txtTitulo.setText(listaEventos.get(position).getTitulo());
            holder.txtDescipcion.setText(listaEventos.get(position).getDescripcion());
            String latitud = String.valueOf(listaEventos.get(position).getLatitud());
            holder.txtLatitud.setText(latitud);
            String longitud = String.valueOf(listaEventos.get(position).getLongitud());
            holder.txtLongitud.setText(longitud);
            long fechaAInsertar;
            fechaAInsertar = Long.parseLong(String.valueOf(listaEventos.get(position).getFecha()));
            String cadenaFecha;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            //Codigo solucion 1970

            if (listaEventos.get(position).getFecha() == 0) {
                cadenaFecha = sdf.format(System.currentTimeMillis());
            } else {
                cadenaFecha = sdf.format(listaEventos.get(position).getFecha());
            }
            holder.txtFecha.setText(cadenaFecha);
        }else{
            holder.txtTitulo.setText("No hay evento.");
        }
    }
    void setWords(List<Evento> eventos){
        this.listaEventos = eventos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (listaEventos != null){
            return listaEventos.size();
        }else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitulo, txtDescipcion, txtLatitud, txtLongitud, txtFecha;

        public ViewHolder(View parent) {
            super(parent);
            txtTitulo = parent.findViewById(R.id.titulo_evento);
            txtDescipcion = parent.findViewById(R.id.descripcion_evento);
            txtLatitud = parent.findViewById(R.id.latitud_evento);
            txtLongitud = parent.findViewById(R.id.longitud_evento);
            txtFecha = parent.findViewById(R.id.fecha_evento);
        }
    }

}