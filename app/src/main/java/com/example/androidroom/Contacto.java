package com.example.androidroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
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
    public String direccion_calle;
    public String direccion_nro;
    public String direccion_piso;
    public String direccion_depto;

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
        
        if (direccion_calle != null) {
            s.append(" Dir: " + direccion_calle +" "+ direccion_nro);

            if (direccion_piso != null || direccion_depto != null) {
                s.append(" ");
                if (direccion_piso != null) {
                    s.append(direccion_piso);
                }
                if (direccion_depto != null) {
                    s.append(direccion_depto);
                }
            }
        }

        return s.toString();
    }
}
