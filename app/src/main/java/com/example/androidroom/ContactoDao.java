package com.example.androidroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface ContactoDao {
    @Query("SELECT * FROM contacto ORDER BY apellido, nombre")
    List<Contacto> obtenerTodos();

    @Transaction
    @Query(
        "SELECT DISTINCT contacto.* " +
        "FROM contacto " +
            "LEFT JOIN telefono ON telefono.contactoId = contacto.id " +
        "WHERE apellido LIKE '%' || :termino || '%' " +
            "OR nombre LIKE '%' || :termino || '%' " +
            "OR fechaNacimiento LIKE '%' || :termino || '%' " +
            "OR apodo LIKE '%' || :termino || '%' " +
            "OR empresa LIKE '%' || :termino || '%' " +
            "OR numero LIKE '%' || :termino || '%' " +
        "ORDER BY apellido, nombre"
    )
    List<Contacto> obtenerPorBusqueda(String termino);

    @Transaction
    @Query("SELECT * FROM contacto WHERE id=:id")
    ContactoConTelefonos obtenerUnoConTelefonos(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertar(Contacto contacto);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertar(Contacto ... contactos);

    @Delete
    void eliminar(Contacto contacto);
}
