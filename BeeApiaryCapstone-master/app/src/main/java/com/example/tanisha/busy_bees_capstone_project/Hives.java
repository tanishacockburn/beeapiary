package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Hives extends AppCompatActivity {
    Button btn_add_hive;
    ListView listView;
    Button btn_add_box;

	private EditText txtHiveName, txtSplitType, txtBoxType, txtNumberFrames, txtFrameMaterial, txtHiveConfiguration,
			txtInstallationDate, txtHoneyWeight, txtHiveType, txtYearBeesWereSourced;
    private ApiaryDB db;
    private ArrayList<HashMap<String, String>> resultset;
	private HashMap items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hives);

        db = new ApiaryDB(this);

        listView = (ListView) findViewById(R.id.hivesListView);

		txtHiveName = (EditText) findViewById(R.id.txtHiveName);
		txtSplitType = (EditText) findViewById(R.id.txtSplitType);
        txtBoxType = (EditText) findViewById(R.id.txtBoxType);
        txtYearBeesWereSourced = (EditText) findViewById(R.id.txtYearBeesWereSourced);
        txtHiveType = (EditText) findViewById(R.id.txtHiveType);
        txtHiveConfiguration = (EditText) findViewById(R.id.txtHiveConfiguration);

        createList();

        AddHivesPage();
        AddBoxPage();


		listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				items = (HashMap) listView.getItemAtPosition(position);
				String temphiveid = items.get("hiveview").toString();
				String[] split = temphiveid.split("^Hive: ");
				Integer hiveid = Integer.parseInt(split[1]);
				Log.d("HiveFunc", String.valueOf(hiveid));
				getHiveById(hiveid);

                txtHiveName.setText(items.get("hiveview").toString());
                txtSplitType.setText(items.get("splitType").toString());
                txtHiveType.setText(items.get("hiveType").toString());
                txtHiveConfiguration.setText(items.get("hiveConfiguration").toString());
				txtYearBeesWereSourced.setText(items.get("yearbeeswereSourced").toString());
			}
		});

    }

    public void AddBoxPage() {

        btn_add_box = (Button) findViewById(R.id.btnAddListBox);
        btn_add_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addBox = new Intent(Hives.this, AddBox.class);
                startActivity(addBox);

            }
        });
    }

    public void AddHivesPage() {
        btn_add_hive = (Button) findViewById(R.id.btnAddHive);
        btn_add_hive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addHive = new Intent(Hives.this, AddHive.class);
                startActivity(addHive);

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
                Intent homePage = new Intent(Hives.this, MainActivity.class);
                startActivity(homePage);

                break;
            case R.id.activity_hives:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent hivesPage = new Intent(Hives.this, Hives.class);
                startActivity(hivesPage);

                break;
            case R.id.activity_records:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent recordPage = new Intent(Hives.this, Records.class);
                startActivity(recordPage);

                break;
            case R.id.activity_new_record:
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_SHORT).show();
                Intent newRecordPage = new Intent(Hives.this, NewRecord.class);
                startActivity(newRecordPage);

                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void createList() {
        resultset = db.getAllHives();
        int resource = R.layout.hive_list;
        String[] from = {"hiveview"};
        int[] to = {R.id.hive_list_tv};

        SimpleAdapter ad = new SimpleAdapter(this, resultset, resource, from, to);
        listView.setAdapter(ad);
    }

	private void getHiveById(Integer hiveId) {
		Log.d("HiveFunc", "Fired");
		//HashMap<String, String> map = new HashMap<String, String>();
		//for (int i = 0; i < resultset.size(); ++i) {
		//	map = (HashMap)resultset.get(i);
			if (hiveId == 3) {
				Log.d("Hive", "If fired");
		//		return map;
			}

		//return null;
	}
}
