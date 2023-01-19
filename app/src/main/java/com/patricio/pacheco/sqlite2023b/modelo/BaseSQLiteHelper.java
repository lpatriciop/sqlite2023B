package com.patricio.pacheco.sqlite2023b.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.io.*;

public class BaseSQLiteHelper  extends SQLiteOpenHelper {

    private static final String BASE="tienda.db";
    private Context miContexto;

    public BaseSQLiteHelper(@Nullable Context context) {
        super(context, BASE, null, 3);
        miContexto=context;
        File archivoBD= miContexto.getDatabasePath(BASE);
        if(!existeBase(archivoBD.getAbsolutePath()))  copiarBD(archivoBD);//UNA SOLA VEZ
    }
    private boolean existeBase(String ruta){
        SQLiteDatabase siDB=null;
        try {
            siDB=SQLiteDatabase.openDatabase(ruta,null,SQLiteDatabase.OPEN_READONLY);
            if (siDB != null) {
                siDB.close();
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }

    }
    private void copiarBD( File archivoDB){
        try {
            InputStream inputStream=miContexto.getAssets().open(BASE);
            OutputStream outputStream = new FileOutputStream(archivoDB);
            byte[] buffer= new byte[1024];
            int largo;
            while((largo=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,largo);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
