package com.example.androidroom;

import android.util.Log;

import androidx.room.TypeConverter;

import org.json.JSONException;
import org.json.JSONObject;

public class DireccionConverter {
    @TypeConverter
    public String direccionToString(Direccion direccion) {
        if (direccion == null) {
            return null;
        }

        JSONObject json = new JSONObject();

        try {
            json.put("calle", direccion.calle);
            json.put("nro", direccion.nro);

            if (direccion.piso != null) {
                json.put("piso", direccion.piso);
            }

            if (direccion.depto != null) {
                json.put("depto", direccion.depto);
            }
        } catch (JSONException e) {
        }

        Log.i("DIRECCION_TO_STRING", json.toString());

        return json.toString();
    }

    @TypeConverter
    public Direccion stringToDireccion(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        Direccion direccion = new Direccion();

        try {
            JSONObject json = new JSONObject(s);

            direccion.calle = json.getString("calle");
            direccion.nro = json.getString("nro");

            if (json.has("piso")) {
                direccion.piso = json.getString("piso");
            }

            if (json.has("depto")) {
                direccion.depto = json.getString("depto");
            }
        } catch (JSONException e) {
        }

        return direccion;
    }
}
