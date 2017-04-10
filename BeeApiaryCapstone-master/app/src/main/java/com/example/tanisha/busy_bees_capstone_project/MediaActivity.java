package com.example.tanisha.busy_bees_capstone_project;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import io.github.steve_bulgin.models.MediaObj;

public class MediaActivity extends AppCompatActivity {

	public static final int IMG_ID = 0;
	public static final int VID_ID = 1;
	private Button btnAddMedia, btnCancel, btnBack;
	private ListView mediahivelist;
	private ArrayList<HashMap<String, String>> resultset;
	private HashMap items;
	private Integer hiveid;
	private ApiaryDB db;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media);

		btnAddMedia = (Button) findViewById(R.id.btnAddMedia);
		btnCancel = (Button) findViewById(R.id.btnMediaCancel);
		btnBack = (Button) findViewById(R.id.btnMediaBack);
		mediahivelist = (ListView) findViewById(R.id.mediahivelist);
		db = new ApiaryDB(this);
		createList();

		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MediaActivity.this, MainActivity.class);
				startActivity(i);
			}
		});

		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		mediahivelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				items = (HashMap) mediahivelist.getItemAtPosition(position);
				hiveid = Integer.parseInt(items.get("hiveID").toString());
				Log.d("HiveFunc", String.valueOf(hiveid));

				btnAddMedia.setText("Add Media for Hive: " + hiveid.toString());

			}
		});


		btnAddMedia.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				try {


					if (hiveid != 0) {

						AlertDialog.Builder alertone = new AlertDialog.Builder(MediaActivity.this);
						alertone.setMessage("Do you want to take a picture or video?").setCancelable(false)
								.setPositiveButton("Picture", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {


										String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
										timestamp = timestamp + ".jpg";

										File folder = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "BeeApiaryData" + File.separator +
												"Images" + File.separator + hiveid.toString());

										if (!folder.exists()) {
											folder.mkdirs();
										}

										File file = new File(folder.getPath() + File.separator + timestamp);

										Uri imageUri = Uri.fromFile(file);
										Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
										intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
										startActivityForResult(intent, IMG_ID);

										MediaObj media = new MediaObj();
										media.setHiveID(hiveid);
										media.setHiveImageStr(file.toString());
										db.snapMedia(media);
									}
								})
								.setNegativeButton("Video", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {

										String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
										timestamp = timestamp + ".mp4";

										File folder = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "BeeApiaryData" + File.separator +
												"Videos" + File.separator + hiveid.toString());

										if (!folder.exists()) {
											folder.mkdirs();
										}

										File file = new File(folder.getPath() + File.separator + timestamp);

										Uri videoUri = Uri.fromFile(file);
										Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
										intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
										startActivityForResult(intent, VID_ID);

										MediaObj media = new MediaObj();
										media.setHiveID(hiveid);
										media.setHiveVideoStr(file.toString());
										db.snapMedia(media);

									}
								});

						AlertDialog alert = alertone.create();
						alert.setTitle("Media options");
						alert.show();
					}
				} catch (NullPointerException e) {
					AlertDialog.Builder builder = new AlertDialog.Builder(MediaActivity.this);
					builder.setMessage("You must select a hive to associate media to before continuing.")
							.setCancelable(false)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

								}
							});
					AlertDialog alert = builder.create();
					alert.setTitle("Select Media");
					alert.show();
				}
			}

		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void createList() {
		resultset = db.getAllHives();
		int resource = R.layout.hive_list;
		String[] from = {"hiveview"};
		int[] to = {R.id.hive_list_tv};

		SimpleAdapter ad = new SimpleAdapter(this, resultset, resource, from, to);
		mediahivelist.setAdapter(ad);
	}
}
