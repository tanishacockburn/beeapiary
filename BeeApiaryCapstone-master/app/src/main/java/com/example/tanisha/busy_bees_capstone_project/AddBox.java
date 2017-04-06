package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.steve_bulgin.models.BoxObj;

public class AddBox extends AppCompatActivity {

    EditText txt_box_type;
    EditText txt_number_of_frames;
    EditText txt_frame_material;
    EditText txt_honey_weight;
    EditText txt_installation_date;
	EditText txt_hive_id;
    Button btn_confirm;
	Button btn_add_box_back;
	Button btnAddBoxCancel;

	private ApiaryDB db;
	private ArrayList<HashMap<String, String>> resultset;
	private HashMap items;
	private ListView listView;
	private Integer hiveid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_box);

		txt_hive_id = (EditText) findViewById(R.id.txtAddBoxId);
        txt_box_type=(EditText)findViewById(R.id.txtBoxType);
        txt_number_of_frames=(EditText)findViewById(R.id.txtNumberOfFrames);
        txt_frame_material=(EditText)findViewById(R.id.txtFrameMaterial);
        txt_honey_weight=(EditText)findViewById(R.id.txtHoneyWeight);
        txt_installation_date=(EditText)findViewById(R.id.txtInstallationDate);
        btn_confirm=(Button)findViewById(R.id.btnReplaceQueenConfirm);
		listView = (ListView) findViewById(R.id.lvHive);
		db = new ApiaryDB(this);

		createList();
        SaveBox();
		BackToMainPage();
		Cancel();

		listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				items = (HashMap) listView.getItemAtPosition(position);
				String temphiveid = items.get("hiveview").toString();
				String[] split = temphiveid.split("^Hive: ");
				hiveid = Integer.parseInt(split[1]);
				Log.d("HiveFunc", String.valueOf(hiveid));

				txt_hive_id.setText(String.valueOf(hiveid));

			}
		});
    }

	public void Cancel() {
		btnAddBoxCancel = (Button) findViewById(R.id.btnAddBoxCancel);
		btnAddBoxCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txt_hive_id.setText("");
				txt_box_type.setText("");
				txt_frame_material.setText("");
				txt_number_of_frames.setText("");
				txt_installation_date.setText("");
			}
		});
	}

	private void BackToMainPage(){

		btn_add_box_back=(Button)findViewById(R.id.btnAddBoxBack);
		btn_add_box_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent backtoMain = new Intent(AddBox.this, Hives.class);
				startActivity(backtoMain);

			}
		});

	}

    public void SaveBox() {
        btn_confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
						Log.d("Addbox", "Click Works");

                        if (txt_box_type.getText().length() == 0) {
                            txt_box_type.setError("please enter box type ");
                        }
                        if ( txt_number_of_frames.getText().length() == 0) {
                            txt_number_of_frames.setError("please enter number of frames ");
                        }
                        if (txt_frame_material.getText().length() == 0) {
                            txt_frame_material.setError("please enter frame material ");
                        }

                        if (txt_installation_date.getText().length() == 0) {
                            txt_installation_date.setError("please enter installation date");
                        }
                        //if (txt_installation_date.getText().length() > 0) {
                            //if (!validDate(txt_installation_date.getText().toString())) {
                                //txt_installation_date.setError("Please insert  date YYYY/MM/DD");
                               // txt_installation_date.requestFocus();
                            //}
                        //}

                        else {
							Log.d("Addbox", "If Works");

							if (hiveid != 0) {
								BoxObj box = new BoxObj();
								box.setHiveID(hiveid);
								box.setBoxType(txt_box_type.getText().toString());
								box.setNumberofFrames(Integer.parseInt(txt_number_of_frames.getText().toString()));
								box.setFrameMaterial(txt_frame_material.getText().toString());
								box.setInstallationDate(txt_installation_date.getText().toString());
								db.addHiveBox(box);
								hiveid = 0;

								Toast.makeText(AddBox.this, "Box is saved ", Toast.LENGTH_LONG).show();
							}
						}
                    }

                    private boolean validDate(String date) {
                        String date_pattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
                        Pattern pattern = Pattern.compile(date_pattern);
                        Matcher matcher = pattern.matcher(date);
                        return matcher.matches();
                    }
                }
        );
    }

	private void createList() {
		resultset = db.getAllHives();
		int resource = R.layout.hive_list;
		String[] from = {"hiveview"};
		int[] to = {R.id.hive_list_tv};

		SimpleAdapter ad = new SimpleAdapter(this, resultset, resource, from, to);
		listView.setAdapter(ad);
	}

}
