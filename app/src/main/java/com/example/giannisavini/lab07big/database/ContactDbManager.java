package com.example.giannisavini.lab07big.database;;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.giannisavini.lab07big.Contact;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gianni.savini on 16/03/2017.
 */
public class ContactDbManager {

    private ContactDbHelper dbHelper;

    public ContactDbManager(Context context) {
        dbHelper = new ContactDbHelper(context);
    }

    public boolean addContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //db.insert ritorna il numero di collonne che sono state aggiunte
        return db.insert(Contact.TABLE_NAME, null, contact.getContentValues()) > 0;
    }

    public boolean updateContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        return db.update(Contact.TABLE_NAME, contact.getContentValues(), Contact._ID + " = ? ",
                new String[]{String.valueOf(contact.getId())}) > 0;
    }

    public boolean deleteContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
         /*
        db.delete ritorna il numero di collonne che sono state cancellate...
        quindi se tutto va bene il numero delle colonne elimi
         */
        return db.delete(Contact.TABLE_NAME, Contact._ID + " = ? ",
                new String[]{String.valueOf(contact.getId())}) > 0;
    }

    public List<Contact> getPeople() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        List<Contact> people = new ArrayList<>();
        Cursor cursor = null;


        try {
            String query = "SELECT * FROM " + Contact.TABLE_NAME + " ORDER BY " + Contact.COLUMN_NAME + " ASC";
            //
            cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                Contact contact = new Contact(cursor);
                people.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return people;
    }

}
