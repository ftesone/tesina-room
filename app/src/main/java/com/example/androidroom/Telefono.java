package com.example.androidroom;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
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
