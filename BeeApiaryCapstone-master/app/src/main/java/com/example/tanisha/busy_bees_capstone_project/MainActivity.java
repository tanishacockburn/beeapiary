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

//		YardObj y1 = new YardObj();
//		y1.setLocation("Permission and Test");
//		y1.setLandDescription("Good place for some bees");
//		db.addYard(y1);
//
//        YardObj y2 = new YardObj();
//        y2.setLocation("Westmount & Ottawa");
//        y2.setLandDescription("Good spot. Small creek near by");
//        db.addYard(y2);
//
//        YardObj y3 = new YardObj();
//        y3.setLocation("Nachos & Victoria");
//        y3.setLandDescription("Little limited");
//        db.addYard(y3);
//
//        HiveObj h1 = new HiveObj();
//        h1.setHiveName("Hive 1");
//		h1.setSplitType("Not Available");
//		h1.setHiveType("Langstrof");
//		h1.setYearbeeswereSourced(2016);
//		h1.setHiveConfiguration("Standard");
//		h1.setYardID(1);
//		db.addHive(h1);
//
//        HiveObj h2 = new HiveObj();
//        h2.setHiveName("Hive 2");
//        h2.setSplitType("Not Available");
//        h2.setHiveType("Langstrof");
//        h2.setYearbeeswereSourced(2016);
//        h2.setHiveConfiguration("Non Standard");
//        h2.setYardID(1);
//        db.addHive(h2);
//
//        HiveObj h3 = new HiveObj();
//        h3.setHiveName("Hive 3");
//        h3.setSplitType("Not Available");
//        h3.setHiveType("Langstrof");
//        h3.setYearbeeswereSourced(2016);
//        h3.setHiveConfiguration("Non Standard");
//        h3.setYardID(2);
//        db.addHive(h3);
//
//        HiveObj h4 = new HiveObj();
//        h4.setHiveName("Hive 4");
//        h4.setSplitType("Not Available");
//        h4.setHiveType("Langstrof");
//        h4.setYearbeeswereSourced(2016);
//        h4.setHiveConfiguration("Non Standard");
//        h4.setYardID(2);
//        db.addHive(h4);
//
//        HiveObj h5 = new HiveObj();
//        h5.setHiveName("Hive 5");
//        h5.setSplitType("Not Available");
//        h5.setHiveType("Langstrof");
//        h5.setYearbeeswereSourced(2016);
//        h5.setHiveConfiguration("Non Standard");
//        h5.setYardID(3);
//        db.addHive(h5);
//
//        HiveObj h6 = new HiveObj();
//        h6.setHiveName("Hive 6");
//        h6.setSplitType("Not Available");
//        h6.setHiveType("Langstrof");
//        h6.setYearbeeswereSourced(2016);
//        h6.setHiveConfiguration("Non Standard");
//        h6.setYardID(3);
//        db.addHive(h6);
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
