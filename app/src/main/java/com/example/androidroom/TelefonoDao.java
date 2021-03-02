package com.example.androidroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface TelefonoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertar(Telefono telefono);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertar(Telefono ... telefonos);

    @Delete
    void eliminar(Telefono telefono);
}
