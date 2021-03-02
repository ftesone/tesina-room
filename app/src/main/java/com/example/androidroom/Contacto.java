package com.example.androidroom;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Contacto {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String apellido;
    public String nombre;
    public Date fechaNacimiento;
    public String apodo;
    public String empresa;

    @NonNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(apellido+", "+nombre);

        if (apodo != null) {
            s.append(" '"+apodo+"'");
        }

        if (fechaNacimiento != null) {
            s.append(" ("+(new SimpleDateFormat("dd/MM/yyyy")).format(fechaNacimiento)+")");
        }

        if (empresa != null) {
            s.append(" @"+empresa);
        }

        return s.toString();
    }
}
