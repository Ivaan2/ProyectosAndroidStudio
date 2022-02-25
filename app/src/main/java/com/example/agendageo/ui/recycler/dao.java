package com.example.agendageo.ui.recycler;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface dao {

    @Insert
    void insert(Evento e);

    @Query("DELETE FROM evento_table")
    void deleteAll();

    @Query("SELECT * from evento_table ORDER BY fecha DESC")
    LiveData <List<Evento>> getAllEvents();
}
