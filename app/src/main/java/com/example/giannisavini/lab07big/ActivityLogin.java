package com.example.giannisavini.lab07big;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    private EditText edtUser;
    private EditText edtPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = (EditText) findViewById(R.id.edt_user_name);
        edtPassword = (EditText) findViewById(R.id.edt_passward);
        login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty()) {
                    new AlertDialog.Builder(ActivityLogin.this)
                            .setTitle("Empty field!")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();

                }
            }
        });
    }
}
