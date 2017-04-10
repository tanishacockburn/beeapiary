package com.example.tanisha.busy_bees_capstone_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaActivity extends AppCompatActivity {

	public static final int IMG_ID = 0;
	public static final int VID_ID = 1;
	private Button btnAddMedia;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media);

		btnAddMedia = (Button) findViewById(R.id.btnAddMedia);


		btnAddMedia.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				AlertDialog.Builder alertone = new AlertDialog.Builder(MediaActivity.this);
				alertone.setMessage("Do you want to take a picture or video?").setCancelable(false)
						.setPositiveButton("Picture", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {




								String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
								timestamp = timestamp + ".jpg";

								File folder = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "Images");

								if (!folder.exists()) {
									folder.mkdirs();
								}

								File file = new File(folder.getPath() + File.separator + timestamp);

								Uri imageUri = Uri.fromFile(file);
								Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
								intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
								startActivityForResult(intent, IMG_ID);
							}
						})
						.setNegativeButton("Video", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
								startActivityForResult(intent, VID_ID);

							}
						});

				AlertDialog alert = alertone.create();
				alert.setTitle("Media options");
				alert.show();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
}
