package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.steve_bulgin.models.YardObj;

public class EditYard extends AppCompatActivity {
    Button btn_edit_yard_confirm;
    EditText txt_edit_yard_location, txt_edit_yard_description;
    Button btn_edit_yard_back, btn_edit_yard_cancel;

	private ApiaryDB db;
	private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_yard2);

        txt_edit_yard_location = (EditText) findViewById(R.id.txtYardLocation);
		txt_edit_yard_description = (EditText)findViewById(R.id.txtYardLandDescription);
        btn_edit_yard_confirm = (Button) findViewById(R.id.btnEditConfirm);
		btn_edit_yard_cancel = (Button) findViewById(R.id.btnEditYardCancel);

		db = new ApiaryDB(this);
		intent = getIntent();

		txt_edit_yard_location.setText(intent.getExtras().getString("location"));
		txt_edit_yard_description.setText(intent.getExtras().getString("landDescription"));


		UpdateYard();
        BackToYardPage();
        BtnEditYardCancel();
    }

    private void BackToYardPage() {

        btn_edit_yard_back = (Button) findViewById(R.id.btnEditYardBack);
        btn_edit_yard_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoMain = new Intent(EditYard.this, Yard.class);
                startActivity(backtoMain);

            }
        });

    }

	private void BtnEditYardCancel() {
		btn_edit_yard_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txt_edit_yard_location.setText("");
				txt_edit_yard_description.setText("");
				Intent cancel = new Intent(EditYard.this, Yard.class);
				startActivity(cancel);
			}
		});
	}

    private void UpdateYard() {

        btn_edit_yard_confirm.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				if (txt_edit_yard_location.getText().length() == 0) {
					txt_edit_yard_location.setError("pleased enter location ");
				} else {
					YardObj yard = new YardObj();
					yard.setLocation(txt_edit_yard_location.getText().toString());
					yard.setLandDescription(txt_edit_yard_description.getText().toString());
					yard.setYardID(Integer.parseInt(intent.getExtras().getString("yardID")));
					db.editYard(yard);
					Toast.makeText(EditYard.this, "Yard Updated", Toast.LENGTH_LONG).show();
				}
				}
			}
        );
    }
}

