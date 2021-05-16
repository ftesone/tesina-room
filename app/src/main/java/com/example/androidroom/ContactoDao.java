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
            "LEFT JOIN email ON email.contactoId = contacto.id " +
        "WHERE contacto.apellido LIKE '%' || :termino || '%' " +
            "OR contacto.nombre LIKE '%' || :termino || '%' " +
            "OR contacto.fechaNacimiento LIKE '%' || :termino || '%' " +
            "OR contacto.apodo LIKE '%' || :termino || '%' " +
            "OR contacto.empresa LIKE '%' || :termino || '%' " +
            "OR contacto.direccion_calle LIKE '%' || :termino || '%' " +
            "OR contacto.direccion_nro LIKE '%' || :termino || '%' " +
            "OR contacto.direccion_piso LIKE '%' || :termino || '%' " +
            "OR contacto.direccion_depto LIKE '%' || :termino || '%' " +
            "OR telefono.numero LIKE '%' || :termino || '%' " +
            "OR email.email LIKE '%' || :termino || '%'" +
        "ORDER BY apellido, nombre"
    )
    List<Contacto> obtenerPorBusqueda(String termino);

    @Transaction
    @Query("SELECT * FROM contacto WHERE id=:id")
    ContactoConRelaciones obtenerUnoConTelefonos(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertar(Contacto contacto);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertar(Contacto ... contactos);

    @Delete
    void eliminar(Contacto contacto);
}
