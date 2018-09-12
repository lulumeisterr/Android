package br.com.fiap.persistencia2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MeuDB extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "MeuDB";
    public static final int VERSION = 1;
    public static final String TB_Cliente="cliente";


    public MeuDB(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE " + TB_Cliente + " (" +
                "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`nome`TEXT NOT NULL " +
                ")";

        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertCliente(Cliente c){

        SQLiteDatabase db = getWritableDatabase();

        // Relizando transferencia de valor
        ContentValues cv = new ContentValues();
        cv.put("nome",c.getNome());

        db.insert(TB_Cliente,null,cv);

    }

    public void updateCliente(Cliente c){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("id",c.getId());
        cv.put("nome",c.getNome());

        // Realizando array de strings
        db.update(TB_Cliente,cv,"id = ?" , new String[]{ String.valueOf(c.getId()) });
    }

    public void deleteCliente(int id){
        // Modo escrita
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TB_Cliente,"id = ?",new String[]{String.valueOf(id)});

    }

    public List<Cliente> getAllClientes(){

        List<Cliente> Clientes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                TB_Cliente,
                new String[]{"id,nome"},
                null,
                null,
                null,
                null,
                "nome ASC");

        while(cursor.moveToNext()){
            Cliente cli = new Cliente();
            cli.setId(cursor.getInt(0));
            cli.setNome(cursor.getString(1));

            //Add lista
            Clientes.add(cli);
        }

        cursor.close();

        return Clientes;
    }
}
