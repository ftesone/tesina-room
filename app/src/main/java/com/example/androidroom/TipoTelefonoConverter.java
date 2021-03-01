package com.example.androidroom;

import androidx.room.TypeConverter;

public class TipoTelefonoConverter {
    @TypeConverter
    public String tipoTelefonoToString(TipoTelefono tipoTelefono)
    {
        switch (tipoTelefono) {
            case MOVIL: return "movil";
            case CASA: return "casa";
            case TRABAJO: return "trabajo";
        }

        return "otro";
    }

    @TypeConverter
    public TipoTelefono stringToTipoTelefono(String tipoTelefono)
    {
        switch (tipoTelefono) {
            case "movil": return TipoTelefono.MOVIL;
            case "casa": return TipoTelefono.CASA;
            case "trabajo": return TipoTelefono.TRABAJO;
        }

        return TipoTelefono.OTRO;
    }
}
