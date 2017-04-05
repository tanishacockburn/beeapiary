package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.steve_bulgin.models.HiveObj;

public class AddHive extends AppCompatActivity {
     Button btn_confirm_add_hive, btn_add_hive_cancel, btn_add_hive_back;
       EditText hiveName;
       EditText hiveType;
       EditText splitType;
       EditText yearBeesWereSourced;
       EditText hiveConfiguration;

	private ApiaryDB db;

//Add hive
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hive);

		db = new ApiaryDB(this);
        hiveName=(EditText)findViewById(R.id.txtHiveName);
        hiveType=(EditText)findViewById(R.id.txtHiveType);
        splitType=(EditText)findViewById(R.id.txtSplitType);
        yearBeesWereSourced=(EditText)findViewById(R.id.txtYearBeesWereSourced);
        hiveConfiguration=(EditText)findViewById(R.id.txtHiveConfiguration);
        btn_confirm_add_hive = (Button)findViewById(R.id.btnAddHiveConfirm);
		btn_add_hive_cancel = (Button)findViewById(R.id.btnAddHiveCancel);
		btn_add_hive_back = (Button)findViewById(R.id.btnAddHiveBack);
        AddData();
		Cancel();
		btnBack();
    }

   public void AddData() {
       btn_confirm_add_hive.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       if (hiveName.getText().length() == 0) {
                           hiveName.setError("please enter a hive name ");
                       }
                       if (hiveType.getText().length() == 0) {
                           hiveType.setError("please enter a hive type ");
                       }
                       if (splitType.getText().length() == 0) {
                           splitType.setError("please enter split type ");
                       }
                       if (yearBeesWereSourced.getText().length() == 0) {
                           yearBeesWereSourced.setError("please enter the year bees were sourced");
                       }
                       if (hiveConfiguration.getText().length() == 0) {
                           hiveConfiguration.setError("please enter hive configuration");
                       } else {
						   HiveObj hive = new HiveObj();
						   hive.setHiveName(hiveName.getText().toString());
						   hive.setHiveType(hiveType.getText().toString());
						   hive.setSplitType(splitType.getText().toString());
						   hive.setYearbeeswereSourced(Integer.parseInt(yearBeesWereSourced.getText().toString()));
						   hive.setHiveConfiguration(hiveConfiguration.getText().toString());
						   db.addHive(hive);
						   Toast.makeText(AddHive.this, "Hive added", Toast.LENGTH_LONG).show();
					   }
                   }
               }
       );

   }

	public void Cancel() {
		btn_add_hive_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				hiveName.setText("");
				hiveType.setText("");
				splitType.setText("");
				yearBeesWereSourced.setText("");
				hiveConfiguration.setText("");
			}
		});
	}

	public void btnBack() {
		btn_add_hive_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(AddHive.this, Hives.class);
				startActivity(i);
			}
		});
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.activityHome:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent homePages = new Intent(AddHive.this, MainActivity.class);
                startActivity(homePages);

                break;
            case R.id.activity_hives:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent hivesPage = new Intent(AddHive.this, Hives.class);
                startActivity(hivesPage);

                break;
            case R.id.activity_records:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent recordsPage = new Intent(AddHive.this, Records.class);
                startActivity(recordsPage);

                break;
            case R.id.activity_new_record:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent newRecordPage = new Intent(AddHive.this, NewRecord.class);
                startActivity(newRecordPage);

                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
