package com.example.tanisha.busy_bees_capstone_project;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.steve_bulgin.models.BoxObj;
import io.github.steve_bulgin.models.HiveObj;
import io.github.steve_bulgin.models.QueenObj;
import io.github.steve_bulgin.models.YardObj;

public class MainActivity extends RuntimePermission {
    public Button btn_hives;
    public Button btn_yard;
    public Button btn_queen;
    public Button btn_inspection;

	private ApiaryDB db;
	//public RuntimePermission permissions;
	private static final int REQUEST_PERMISSION = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HivesPage();
        YardPage();
        QueenPage();
        InspectionPage();

		requestAppPermissions(new String[]{
				Manifest.permission.WRITE_EXTERNAL_STORAGE,
				Manifest.permission.READ_EXTERNAL_STORAGE,
				Manifest.permission.CAMERA}, R.string.msg, REQUEST_PERMISSION);




    }

    private void InspectionPage() {

        btn_inspection=(Button)findViewById(R.id.btnInspection);
        btn_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recordList = new Intent(MainActivity.this, RecordList.class);
                startActivity(recordList);

            }
        });
    }

	@Override
	public void onPermissionsGranted(int requestCode) {

		db = new ApiaryDB(this);


	}


	public  void HivesPage()
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

    public  void YardPage()
    {
		Log.d("Yard", "Fired");
        btn_yard=(Button)findViewById(R.id.btnYard);
        btn_yard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yard = new Intent(MainActivity.this, Yard.class);
                startActivity(yard);

            }
        });
    }
    public  void QueenPage()
    {
        btn_queen=(Button)findViewById(R.id.btnQueen);
        btn_queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent queen = new Intent(MainActivity.this, Queen.class);
                startActivity(queen);

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
