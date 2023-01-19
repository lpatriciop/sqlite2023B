package com.patricio.pacheco.sqlite2023b.modelo;

import android.content.Context;
import android.database.Cursor;

public class Persona {
    private String id;
    private String nombre;
    private String estadoCivil;
    private String tipoSangre;

    public Persona() {
    }

    public Persona(String id, String nombre, String estadoCivil, String tipoSangre) {
        this.id = id;
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.tipoSangre = tipoSangre;
    }
//MODELO DE PERSONA
    public void guardarPersona(Context context){
        String sql="INSERT INTO persona (id,nombre,estado_civil,tipo_sangre)";
        sql+="VALUES ('"+getId()+"','"+getNombre()+"','"+getEstadoCivil()+"','"+getTipoSangre()+"')";
        BaseSQLiteHelper baseSQLiteHelper= new BaseSQLiteHelper(context);
        baseSQLiteHelper.getWritableDatabase().execSQL(sql);
    }

    public static Cursor listaPersona(Context context){
        String sql="select _rowid_ as _id, * from persona";
        BaseSQLiteHelper sqLiteHelper= new BaseSQLiteHelper(context);
       return sqLiteHelper.getReadableDatabase().rawQuery(sql,null);

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
