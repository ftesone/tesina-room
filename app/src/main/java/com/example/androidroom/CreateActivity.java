package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateActivity extends AppCompatActivity {
    private static String[] apellidos = {"Sánchez", "Ginóbilli", "Montecchia", "Oberto", "Victoriano", "Fernández", "Sconochini", "Scola", "Gutiérrez", "Nocioni", "Palladino", "Wolkowyski", "Magnano"};
    private static String[] nombres = {"Juan", "Emanuel", "Alejandro", "Fabricio", "Lucas", "Gabriel", "Hugo", "Luis", "Leonardo", "Andrés", "Leandro", "Rubén", "Ignacio"};
    private static String[] apodos = {"Pepe", "Manu", "Chapu", "Leo", "Colo", "Luifa", "Puma"};
    private static String[] empresas = {"Pied Piper", "Aviato", "Raviga", "Nucleus", "Endframe", "SeeFood"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        String apellido = apellidos[random(0, apellidos.length-1)];
        String nombre = nombres[random(0, nombres.length-1)];

        String apodo = null;
        if (0 == random(0,3)) {
            apodo = apodos[random(0, apodos.length-1)];
        }

        Date fechaNacimiento = null;
        if (0 == random(0,3)) {
            fechaNacimiento = getRandomDate();
        }

        String empresa = null;
        if (0 == random(0,3)) {
            empresa = empresas[random(0, empresas.length-1)];
        }

        String direccion_calle = null, direccion_nro = null, direccion_piso = null, direccion_depto = null;
        if (0 == random(0,3)) {
            direccion_calle = String.valueOf(random(1, 72));
            direccion_nro = String.valueOf(random(100, 1000));

            if (0 != random(0,2)) {
                direccion_piso = random(1,15) + "º";
            }

            if (0 != random(0,2)) {
                direccion_depto = String.valueOf((char) random(65,70));
            }
        }

        DB db = Room.databaseBuilder(getApplicationContext(), DB.class, String.valueOf(R.string.database)).allowMainThreadQueries().build();

        Contacto contacto = new Contacto();
        contacto.apellido = apellido;
        contacto.nombre = nombre;

        if (apodo != null) {
            contacto.apodo = apodo;
        }

        if (fechaNacimiento != null) {
            contacto.fechaNacimiento = fechaNacimiento;
        }

        if (empresa != null) {
            contacto.empresa = empresa;
        }

        if (direccion_calle != null) {
            contacto.direccion_calle = direccion_calle;
            contacto.direccion_nro = direccion_nro;

            if (direccion_piso != null) {
                contacto.direccion_piso = direccion_piso;
            }

            if (direccion_depto != null) {
                contacto.direccion_depto = direccion_depto;
            }
        }

        long id = db.contactoDao().insertar(contacto);

        List<Telefono> telefonos = new ArrayList<>();
        for (int i=0, j=random(0,4) ; i<=j ; i++) {
            Telefono telefono = new Telefono();
            telefono.contactoId = id;
            telefono.numero = String.valueOf(random(1000,9999));
            telefono.tipo = getRandomTipoTelefono();
            telefonos.add(telefono);
        }

        if (!telefonos.isEmpty()) {
            db.telefonoDao().insertar(telefonos.toArray(new Telefono[telefonos.size()]));
        }

        List<Email> emails = new ArrayList<>();
        for (int i=0, j=random(0,4) ; i<=j ; i++) {
            Email email = new Email();
            email.contactoId = id;
            email.email = contacto.nombre.charAt(0) + contacto.apellido.toLowerCase() + (i==0 ? "" : i) + "@mail.com";
            emails.add(email);
        }

        if (!emails.isEmpty()) {
            db.emailDao().insertar(emails.toArray(new Email[emails.size()]));
        }

        TextView textView = (TextView) findViewById(R.id.contacto);
        textView.setText(contacto.toString());

        ArrayAdapter<Telefono> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, telefonos);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        ArrayAdapter<Email> emailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emails);
        ListView listViewEmail = (ListView) findViewById(R.id.emails);
        listViewEmail.setAdapter(emailAdapter);
    }

    private int random(int start, int end)
    {
        return start + (int) Math.round(Math.random() * (end-start));
    }

    private Date getRandomDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, random(1950,2000));
        calendar.set(Calendar.DAY_OF_YEAR, random(1,365));

        return calendar.getTime();
    }

    private TipoTelefono getRandomTipoTelefono()
    {
        TipoTelefono[] values = TipoTelefono.values();

        return values[random(0, values.length-1)];
    }
}
