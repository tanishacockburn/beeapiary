package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.steve_bulgin.models.HiveObj;
import io.github.steve_bulgin.models.YardObj;

public class AddYard extends AppCompatActivity {
    EditText txt_yard_location, txt_land_description;
	private ApiaryDB db;
    Button btn_confirm, btnCancel, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_yard);

		db = new ApiaryDB(this);
        txt_yard_location=(EditText)findViewById(R.id.txtAddYardYardLocation);
		txt_land_description = (EditText) findViewById(R.id.txtAddYardLandDescription);
		btn_confirm=(Button)findViewById(R.id.btnAddYardConfirm);
		btnCancel = (Button) findViewById(R.id.btnAddYardCancel);
		btnBack = (Button) findViewById(R.id.btnEditYardBack);
        SaveYard();
		Cancel();
		Back();
    }

	public void Back() {
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent backtoMain = new Intent(AddYard.this, Yard.class);
				startActivity(backtoMain);
			}
		});
	}

	public void Cancel() {
		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txt_land_description.setText("");
				txt_yard_location.setText("");
				Intent backToMain = new Intent(AddYard.this, Yard.class);
				startActivity(backToMain);

			}
		});
	}

    public void SaveYard() {

        btn_confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (txt_yard_location.getText().length()==0)
                        {
                            txt_yard_location.setError("Please enter Yard location ");
                        }

                        else {
							YardObj yard = new YardObj();

							yard.setLocation(txt_yard_location.getText().toString());
							yard.setLandDescription(txt_land_description.getText().toString());
							db.addYard(yard);

							Toast.makeText(AddYard.this, "Yard Added", Toast.LENGTH_LONG).show();
							Intent i = new Intent(AddYard.this, Yard.class);
							startActivity(i);
						}
                    }
                }
        );
    }
}
