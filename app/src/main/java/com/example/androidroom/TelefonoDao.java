package com.example.androidroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface TelefonoDao {
    @Insert
    void insertar(Telefono ... telefono);

    @Delete
    void eliminar(Telefono telefono);
}
