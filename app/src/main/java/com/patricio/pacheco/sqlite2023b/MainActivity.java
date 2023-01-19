package com.patricio.pacheco.sqlite2023b;

import android.database.Cursor;
import android.os.PerformanceHintManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.patricio.pacheco.sqlite2023b.modelo.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonGuardaPersona=(Button) findViewById(R.id.buttonGrabar);
        buttonGuardaPersona.setOnClickListener(l->guardaPersona());

        Button buttonListar=(Button) findViewById(R.id.buttonListar);
        buttonListar.setOnClickListener(l->listaPersonas());
    }
    private void listaPersonas(){
        ListView listPersonas=(ListView) findViewById(R.id.listViewPersonas);
        Cursor cursor = Persona.listaPersona(getApplicationContext());
        String[] from = new String[]{"id","nombre","estado_civil","tipo_sangre"};
        int[] to = new int[]{R.id.txtDetalleID,R.id.txtDetalleNombre,R.id.txtDetalleEC,R.id.txtDetalleTS};
        CursorAdapter cursorAdapter= new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.detalle_persona,
                cursor, from,to,0
        );
        listPersonas.setAdapter(cursorAdapter);
    };
    private void guardaPersona(){
        EditText editTextID=(EditText) findViewById(R.id.editTextID);
        EditText editTextNombre=(EditText) findViewById(R.id.editTextNombre);
        EditText editTextTS=(EditText) findViewById(R.id.editTextTipoSangre);
        Persona persona= new Persona();
        persona.setId(editTextID.getText().toString());
        persona.setNombre(editTextNombre.getText().toString());
        persona.setEstadoCivil("CASADO/A");
        persona.setTipoSangre(editTextTS.getText().toString());
        persona.guardarPersona(getApplicationContext());
        Toast.makeText(getApplicationContext(),"PERSONA CREADA SATISFACTORIAMENTE",Toast.LENGTH_LONG).show();
    }
}