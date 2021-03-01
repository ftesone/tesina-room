package com.example.androidroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Contacto {
    @PrimaryKey
    public int id;

    public String apellido;
    public String nombre;
    public Date fechaNacimiento;
    public String apodo;
    public String empresa;
}
