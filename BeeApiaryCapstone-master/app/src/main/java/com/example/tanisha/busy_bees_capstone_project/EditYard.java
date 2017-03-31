package com.example.tanisha.busy_bees_capstone_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditYard extends AppCompatActivity {
    Button btn_edit_yard_confirm;
    EditText txt_edit_yard_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_yard2);

        txt_edit_yard_location = (EditText) findViewById(R.id.txtYardLocation);
        btn_edit_yard_confirm = (Button) findViewById(R.id.btnEditConfirm);
        UpdateYard();
    }

    private void UpdateYard() {

        btn_edit_yard_confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (txt_edit_yard_location.getText().length() == 0) {
                            txt_edit_yard_location.setError("pleased enter location ");
                        } else
                            Toast.makeText(EditYard.this, "Yard Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

