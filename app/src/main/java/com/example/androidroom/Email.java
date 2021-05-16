package com.example.androidroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
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
