package com.patricio.pacheco.sqlite2023b;

import android.os.PerformanceHintManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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
    }
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