package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordList extends AppCompatActivity {
    public Button btn_record_list_back;

	private ListView hivelist, inspectionlist;
	private HashMap items, inspectionitems;
	private ApiaryDB db;
	private ArrayList<HashMap<String, String>> resultset, inspectionresultset;
	private Integer hiveid, inspectionid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);

		hivelist = (ListView) findViewById(R.id.lvlHives);
		inspectionlist = (ListView) findViewById(R.id.lvInspectionList);

		db = new ApiaryDB(this);

		createList();

		hivelist.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				items = (HashMap) hivelist.getItemAtPosition(position);
				String temphiveid = items.get("hiveID").toString();
				hiveid = Integer.parseInt(temphiveid);
				createInspectionList(hiveid);
			}
		});

		inspectionlist.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				inspectionitems = (HashMap) inspectionlist.getItemAtPosition(position);
				inspectionid = Integer.parseInt(inspectionitems.get("inspectionID").toString());

				if (inspectionid != null || inspectionid != 0) {
					Intent i = new Intent(RecordList.this, Records.class);
					i.putExtra("inspectionID", inspectionitems.get("inspectionID").toString());
					i.putExtra("dateofInspection", inspectionitems.get("dateofInspection").toString());
					i.putExtra("hiveBehaviour", inspectionitems.get("hiveBehaviour").toString());
					i.putExtra("observation", inspectionitems.get("observation").toString());
					i.putExtra("concern", inspectionitems.get("concern").toString());
					i.putExtra("hiveID", inspectionitems.get("hiveID").toString());
					i.putExtra("pestSeen", inspectionitems.get("pestSeen").toString());
					i.putExtra("pestManagement", inspectionitems.get("pestManagement").toString());
					i.putExtra("treatmentapplied", inspectionitems.get("treatmentapplied").toString());
					inspectionid = 0;
					startActivity(i);
				}
			}
		});



        BackToMainPage();
    }

    private void BackToMainPage() {

        btn_record_list_back=(Button)findViewById(R.id.btnRecordListBack);
        btn_record_list_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoMain = new Intent(RecordList.this, MainActivity.class);
                startActivity(backtoMain);
            }
        });

    }

	private void createList() {
		resultset = db.getAllHives();
		int resource = R.layout.hive_list;
		String[] from = {"hiveview"};
		int[] to = {R.id.hive_list_tv};

		SimpleAdapter ad = new SimpleAdapter(this, resultset, resource, from, to);
		hivelist.setAdapter(ad);
	}

	private void createInspectionList(int hiveid) {
		inspectionresultset = db.getInspectionsByHiveId(hiveid);
		int resource = R.layout.record_list;
		String[] from = {"dateofInspection"};
		int[] to = {R.id.inspection_list_tv};

		SimpleAdapter ad = new SimpleAdapter(this, inspectionresultset, resource, from, to);
		inspectionlist.setAdapter(ad);
	}
}
