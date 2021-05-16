package com.example.androidroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface EmailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertar(Email email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertar(Email ... emails);

    @Delete
    void eliminar(Email email);
}
