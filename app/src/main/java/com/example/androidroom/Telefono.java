package com.example.androidroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Telefono {
    @PrimaryKey
    public int id;

    public String numero;
    public TipoTelefono tipo;

    public int contactoId;
}
