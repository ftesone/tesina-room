package com.example.androidroom;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contacto {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String apellido;
    public String nombre;
    public Date fechaNacimiento;
    public String apodo;
    public String empresa;
    public Direccion direccion;

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
        
        if (direccion != null) {
            s.append(" Dir: " + direccion.calle +" "+ direccion.nro);

            if (direccion.piso != null || direccion.depto != null) {
                s.append(" ");
                if (direccion.piso != null) {
                    s.append(direccion.piso);
                }
                if (direccion.depto != null) {
                    s.append(direccion.depto);
                }
            }
        }

        return s.toString();
    }
}
