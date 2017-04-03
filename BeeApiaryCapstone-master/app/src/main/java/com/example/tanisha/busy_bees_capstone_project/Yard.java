package com.example.tanisha.busy_bees_capstone_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Yard extends AppCompatActivity {
    public Button btn_add_yard ;
    public Button btn_edit_yard;
    public  Button btn_back_yard;

	private Button btn_delete;
	private TextView txtlocation, txtlanddescription;
	private ListView hive_list_items;
	private ApiaryDB db;
	private ArrayList<HashMap<String, String>> resultset;
	private HashMap items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yard);

		txtlanddescription = (TextView)findViewById(R.id.txtYardLandDescription);
		txtlocation = (TextView)findViewById(R.id.txtYardLocation);

		db = new ApiaryDB(this);

		hive_list_items = (ListView) findViewById(R.id.lvHiveList);
		createList();

		hive_list_items.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				items = (HashMap) hive_list_items.getItemAtPosition(position);
				String hiveandlocation = items.get("hivelv").toString();
				String[] split = hiveandlocation.split("^[\\s|\\d]+");
				String location = split[1].trim();
				Toast.makeText(getApplicationContext(), location, Toast.LENGTH_LONG).show();

				items = getYardByLocation(location);
				txtlocation.setText(items.get("location").toString());
				txtlanddescription.setText(items.get("landDescription").toString());

			}
		});

		DeleteYard();
        AddYardPage();
        EditYardPage();
        //BackToMainPage();

    }

    private void BackToMainPage(){

            btn_back_yard=(Button)findViewById(R.id.btnEditYardBack);
            btn_back_yard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent backtoMain = new Intent(Yard.this, MainActivity.class);
                    startActivity(backtoMain);

                }
            });

    }

    private void AddYardPage() {
        btn_add_yard=(Button)findViewById(R.id.btnAddYard);
        btn_add_yard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addYard = new Intent(Yard.this, AddYard.class);
                startActivity(addYard);

            }
        });
    }
    private void EditYardPage()
    {
        btn_edit_yard=(Button)findViewById(R.id.btnEditYard);
        btn_edit_yard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				String location = null;

				try {

					String hiveandlocation = items.get("hivelv").toString();
					String[] split = hiveandlocation.split("^[\\s|\\d]+");
					location = split[1].trim();
				} catch (NullPointerException e) {

				}

				if (location != null && !location.isEmpty()) {

					HashMap<String, String> map = new HashMap<String, String>();

					for (int i = 0; i < resultset.size(); ++i) {
						map = (HashMap) resultset.get(i);
						if (location.equals(map.get("location"))) {
							Intent editYard = new Intent(Yard.this, EditYard.class);
							editYard.putExtra("yardID", map.get("yardID"));
							editYard.putExtra("location", map.get("location"));
							editYard.putExtra("landDescription", map.get("landDescription"));
							startActivity(editYard);
						}
					}
				}

            }
        });
    }

	private void DeleteYard() {

		btn_delete = (Button) findViewById(R.id.btnDeleteYard);

		btn_delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String location = null;

				try {

					String hiveandlocation = items.get("hivelv").toString();
					String[] split = hiveandlocation.split("^[\\s|\\d]+");
					location = split[1].trim();
				} catch (NullPointerException e) {

				}

				if (location != null && !location.isEmpty()) {

					HashMap<String, String> map = new HashMap<String, String>();
					//Log.d("Land1", map.get("landDescription"));

					for (int i = 0; i < resultset.size(); ++i) {
						map = (HashMap) resultset.get(i);
						if (location.equals(map.get("location"))) {
							final int tempint = Integer.parseInt(map.get("yardID"));

							AlertDialog.Builder alertone = new AlertDialog.Builder(Yard.this);
							alertone.setMessage("Do you really want to delete this yard and all hives associated to it?").setCancelable(false)
									.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialog, int which) {
											db.rowDeleter("Yard", "yardID", tempint);
											txtlocation.setText("");
											txtlanddescription.setText("");
											createList();
										}
									})
									.setNegativeButton("No", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialog, int which) {
											dialog.cancel();
										}
									});

							AlertDialog alert = alertone.create();
							alert.setTitle("Delete Yard");
							alert.show();
						}
					}
				}
			}
		});

	}

	private void createList() {
		resultset = db.getAllHivesandYards();
		int resource = R.layout.hive_list;
		String[] from = {"hivelv"};
		int[] to = {R.id.hive_list_tv};

		SimpleAdapter ad = new SimpleAdapter(this, resultset,resource,from,to);
		hive_list_items.setAdapter(ad);
	}

	private HashMap<String, String> getYardByLocation(String location) {
		HashMap<String, String> map = new HashMap<String, String>();
		//Log.d("Land1", map.get("landDescription"));

		for (int i = 0; i < resultset.size(); ++i) {
			map = (HashMap)resultset.get(i);
			if (location.equals(map.get("location"))) {
				Log.d("Land1", map.get("location") + " " + map.get("landDescription"));
				return map;
			}
		}
		return null;
	}

}
