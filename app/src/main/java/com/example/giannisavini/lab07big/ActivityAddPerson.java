package com.example.giannisavini.lab07big;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by gianni.savini on 20/04/2017.
 */
public class ActivityAddPerson extends AppCompatActivity {

    private EditText edtName;
    private EditText edtSurname;
    private EditText edtNumber;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edt_name);
        edtSurname = (EditText) findViewById(R.id.edt_surname);
        edtNumber = (EditText) findViewById(R.id.edt_number);
        add = (Button) findViewById(R.id.button2);
    }
}
