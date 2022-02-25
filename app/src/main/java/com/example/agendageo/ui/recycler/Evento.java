package com.example.agendageo.ui.recycler;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "evento_table")
public class Evento {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "longitud")
    public double longitud;

    @ColumnInfo(name = "latitud")
    public double latitud;

    @ColumnInfo(name = "fecha")
    public long fecha;

    @NonNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public Evento(@NonNull String titulo, @NonNull String descripcion, @NonNull double longitud, @NonNull double latitud, @NonNull long fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", longitud='" + longitud + '\'' +
                ", latitud='" + latitud + '\'' +
                '}';
    }
}
