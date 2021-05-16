package com.example.androidroom;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ContactoConTelefonos {
    @Embedded
    public Contacto contacto;

    @Relation(parentColumn = "id", entityColumn = "contactoId")
    public List<Telefono> telefonos;
}
