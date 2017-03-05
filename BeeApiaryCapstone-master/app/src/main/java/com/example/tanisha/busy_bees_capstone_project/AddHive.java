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

public class AddHive extends AppCompatActivity {
    Button addHive;
    EditText hiveName;
//Add hive
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hive);

        addHive= (Button)findViewById(R.id.btnAddHive);
        hiveName=(EditText)findViewById(R.id.txtHiveName);
        AddData();





    }

    public void AddData()
    {
        addHive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (hiveName.getText().length()==0)
                        {
                            hiveName.setError("pleased enter a name ");
                        }
                        else
                            Toast.makeText(AddHive.this,"Data name ok",Toast.LENGTH_LONG).show();
                    }
                }
        );


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
