package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MediaActivity extends AppCompatActivity {
    Button btnCam;
    EditText hiveName;
//Add hive
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        btnCam = (Button)findViewById(R.id.btnCam);

        CameraLaunch();








    }

    public void CameraLaunch()
    {
        btnCam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("Cambtn", "Fired");
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivityForResult(intent, 0);
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
                Intent homePages = new Intent(MediaActivity.this, MainActivity.class);
                startActivity(homePages);

                break;
            case R.id.activity_hives:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent hivesPage = new Intent(MediaActivity.this, Hives.class);
                startActivity(hivesPage);

                break;
            case R.id.activity_records:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent recordsPage = new Intent(MediaActivity.this, Records.class);
                startActivity(recordsPage);

                break;
            case R.id.activity_new_record:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent newRecordPage = new Intent(MediaActivity.this, NewRecord.class);
                startActivity(newRecordPage);

                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
