package com.example.androidroom;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Contacto.class, parentColumns = {"id"}, childColumns = {"contactoId"})})
public class Email {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String email;

    public long contactoId;

    @Override
    public String toString() {
        return email;
    }
}
