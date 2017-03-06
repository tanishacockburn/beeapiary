package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_hives, btn_records, btn_new_record, btn_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HiveesPage();
        YardsPage();
        QueensPage();
        MediaPage();

    }

    public  void MediaPage()
    {
        btn_media=(Button)findViewById(R.id.btnMedia);
        btn_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hives = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(hives);

            }
        });
    }

    public  void HiveesPage()
    {
        btn_hives=(Button)findViewById(R.id.btnHive);
        btn_hives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hives = new Intent(MainActivity.this, Hives.class);
                startActivity(hives);

            }
        });
    }


    public  void YardsPage()
    {
        btn_records=(Button)findViewById(R.id.btnYards);
        btn_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent records = new Intent(MainActivity.this, Records.class);
                startActivity(records);

            }
        });
    }

    public  void QueensPage()
    {
        btn_new_record=(Button)findViewById(R.id.btnQueens);
        btn_new_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newRecords = new Intent(MainActivity.this, NewRecord.class);
                startActivity(newRecords);

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


        switch (item.getItemId()){
            case R.id.activityHome:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent homePages = new Intent(MainActivity.this, MainActivity.class);
                startActivity(homePages);

                break;
            case R.id.activity_hives:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent hivesPage = new Intent(MainActivity.this, Hives.class);
                startActivity(hivesPage);

                break;
            case R.id.activity_records:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent recordsPage = new Intent(MainActivity.this, Records.class);
                startActivity(recordsPage);

                break;
            case R.id.activity_new_record:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent newRecordPage = new Intent(MainActivity.this, NewRecord.class);
                startActivity(newRecordPage);

                break;




        }



        return super.onOptionsItemSelected(item);
    }

}
