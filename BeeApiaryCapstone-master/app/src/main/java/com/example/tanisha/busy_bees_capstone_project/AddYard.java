package com.example.tanisha.busy_bees_capstone_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddYard extends AppCompatActivity {
    EditText txt_yard_location;
    EditText  txt_land_description;
    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_yard);

        txt_yard_location=(EditText)findViewById(R.id.txtAddYardYardLocation);
        btn_confirm=(Button)findViewById(R.id.btnAddYardConfirm);
        SaveYard();



    }

    public void SaveYard() {

        btn_confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (txt_yard_location.getText().length()==0)
                        {
                            txt_yard_location.setError("pleased enter a name ");
                        }

                        else
                            Toast.makeText(AddYard.this,"Yard added",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
