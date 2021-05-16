package com.example.androidroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Contacto.class, Telefono.class, Email.class}, version = 1)
@TypeConverters({DateConverter.class, TipoTelefonoConverter.class})
public abstract class DB extends RoomDatabase {
    public abstract ContactoDao contactoDao();
    public abstract TelefonoDao telefonoDao();
    public abstract EmailDao emailDao();
}
