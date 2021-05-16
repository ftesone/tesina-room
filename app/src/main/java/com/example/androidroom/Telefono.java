package com.example.androidroom;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Contacto.class, parentColumns = {"id"}, childColumns = {"contactoId"})})
public class Telefono {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String numero;
    public TipoTelefono tipo;

    public long contactoId;

    @NonNull
    @Override
    public String toString() {
        return tipo.toString() + ": "+numero;
    }
}
