package com.example.giannisavini.lab07big.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.giannisavini.lab07big.Contact;

/**
 * Created by gianni.savini on 20/04/2017.
 */
public class ContactDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "exercises.db";
    private static final int DATABASE_VERSION = 1;


    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String CREATE_TABLE_PEOPLE = "CREATE TABLE "
            + Contact.TABLE_NAME +" (" +
            Contact._ID + " INTEGER PRIMARY KEY, " +
            Contact.COLUMN_NAME + " TEXT, " +
            Contact.COLUMN_SURNAME + " TEXT, " +
            Contact.COLUMN_NUMBER + " TEXT, " +
            Contact.COLUMN_EMAIL + " TEXT )";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PEOPLE);
    }

    //Permette di gestire le varie versioni dell'applicazione
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
