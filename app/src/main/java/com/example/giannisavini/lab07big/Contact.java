package com.example.giannisavini.lab07big;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * Created by gianni.savini on 20/04/2017.
 */
public class Contact implements BaseColumns {
    //variabili statiche  per la gestione della tabella
    public static final String TABLE_NAME = "people";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_EMAIL = "e_mail";

    private int id;
    private String name;
    private String surname;
    private String number;
    private String email;

    public Contact(final String name,final String surname,final String number,final String email) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
    }

    public Contact(final Cursor cursor) {
        //Chiamo il costruttore sopra, con i parametri del cursor
        this(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)), cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)),
                cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)), cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)));
        this.id = cursor.getInt(cursor.getColumnIndex(_ID));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public ContentValues getContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, this.name);
        cv.put(COLUMN_SURNAME, this.surname);
        cv.put(COLUMN_NUMBER, this.number);
        cv.put(COLUMN_EMAIL, this.email);
        return cv;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
