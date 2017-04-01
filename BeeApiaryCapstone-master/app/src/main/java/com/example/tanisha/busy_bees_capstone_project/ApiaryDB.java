package com.example.tanisha.busy_bees_capstone_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import io.github.steve_bulgin.models.*;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class ApiaryDB {

	public static final String DB_NAME = "apiary.db";
	public static final int DB_VERSION = 1;
	public static final String DATABASE_FILE_PATH  = Environment.getExternalStorageDirectory().toString();

	//FlowerObj CONSTS
	public static final String FLOWER = "Flower";
	public static final String FLOWERID = "flowerID";
	public static final String COMMONNAME = "commonName";
	public static final String SCIENTIFICNAME = "scientificName";
	public static final String STARTOFSEASON = "startofSeason";
	public static final String ENDOFSEASON = "endofSeason";

	//Yard CONSTS
	public static final String YARD = "Yard";
	public static final String YARDID = "yardID";
	public static final String LOCATION = "location";
	public static final String LANDDESCRIPTION = "landDescription";

	//Hive CONSTS
	public static final String HIVE = "Hive";
	public static final String HIVEID = "hiveID";
	public static final String HIVENAME = "hiveName";
	public static final String SPLITTYPE = "splitType";
	public static final String HIVETYPE = "hiveType";
	public static final String YEARBEESWERESOURCED = "yearbeeswereSourced";
	public static final String HIVECONFIGURATION = "hiveConfiguration";

	//Queen CONSTS
	public static final String QUEEN = "Queen";
	public static final String QUEENID = "queenID";
	public static final String QUEENBIRTH = "queenBirth";
	public static final String QUEENREPLACED = "queenReplaced";

	//Box CONSTS
	public static final String BOX = "Box";
	public static final String BOXID = "boxID";
	public static final String BOXTYPE = "boxType";
	public static final String NUMBEROFFRAMES = "numberofFrames";
	public static final String FRAMEMATERIAL = "frameMaterial";
	public static final String INSTALLATIONDATE = "installationDate";
	public static final String HARVESTDATE = "harvestDate";
	public static final String HONEYWEIGHT = "honeyWeight";

	//Media CONSTS
	public static final String MEDIA = "Media";
	public static final String MEDIAID = "mediaID";
	public static final String HIVEIMAGESTR = "hiveImageStr";
	public static final String HIVEVIDEOSTR = "hiveVideoStr";

	//Inspection CONSTS
	public static final String INSPECTION = "Inspection";
	public static final String INSPECTIONID = "inspectionID";
	public static final String DATEOFINSPECTION = "dateofInspection";
	public static final String HIVEBEHAVIOUR = "hiveBehaviour";
	public static final String OBSERVATION = "observation";
	public static final String CONCERN = "concern";

	//Treatment CONSTS
	public static final String TREATMENT = "Treatment";
	public static final String TREATMENTID = "treatmentID";
	public static final String TREATMENTAPPLIED = "treatmentapplied";
	public static final String CONCERNS = "concerns";

	//Pest CONSTS
	public static final String PEST = "Pest";
	public static final String PESTID = "pestID";
	public static final String PESTSEEN = "pestSeen";
	public static final String PESTMANAGEMENT = "pestManagement";


	private static class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context, String name,
						SQLiteDatabase.CursorFactory factory, int version) {
			super(context, DATABASE_FILE_PATH + File.separator + "BeeApiaryData" + File.separator + DB_NAME, factory, version);
		}


		@Override
		public void onCreate(SQLiteDatabase db) {
			// create tables

			Log.d("DBPath", DATABASE_FILE_PATH);

			//Set fk constraints
			db.execSQL("PRAGMA foreign_keys = ON");


			//FlowerObj table
			db.execSQL("CREATE TABLE " + FLOWER + " ( " + FLOWERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + YARDID +
					" INTEGER, " + COMMONNAME + " VARCHAR NOT NULL, " + SCIENTIFICNAME + " VARCHAR,  " + STARTOFSEASON + 
					" VARCHAR, " + ENDOFSEASON + " VARCHAR, " +
					" FOREIGN KEY (yardID) REFERENCES Yard(yardID) ON DELETE CASCADE)");

			//Yard table
			db.execSQL("CREATE TABLE "+ YARD +" ( " + YARDID + " INTEGER PRIMARY KEY AUTOINCREMENT," + LOCATION +
					" VARCHAR NOT NULL, " + LANDDESCRIPTION + " VARCHAR )");
			//Hive
			db.execSQL("CREATE TABLE " + HIVE + " ( " + HIVEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HIVENAME + " VARCHAR, " + SPLITTYPE + " VARCHAR, " + HIVETYPE + " VARCHAR, " +
					   " " + YEARBEESWERESOURCED + " INTEGER, "+ HIVECONFIGURATION +" VARCHAR, " + YARDID + " INTEGER, " +
					   " FOREIGN KEY (yardID) REFERENCES Yard(yardID) ON DELETE CASCADE )");

			//Queen table
			db.execSQL("CREATE TABLE " + QUEEN + " ( " + QUEENID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + QUEENBIRTH + " VARCHAR, " + QUEENREPLACED + " VARCHAR, " + HIVEID + " INTEGER NOT NULL, " +
					   "FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE)");

			//Box table
			db.execSQL("CREATE TABLE "+ BOX +" ( " + BOXID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOXTYPE + " VARCHAR, " + NUMBEROFFRAMES + " INTEGER, " + FRAMEMATERIAL + " VARCHAR, " +
					   " " + INSTALLATIONDATE + " VARCHAR, " + HARVESTDATE + " VARCHAR, " + HONEYWEIGHT + " DOUBLE, " + HIVEID + " INTEGER NOT NULL, " +
					   " FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE )");

			//Media Table
			db.execSQL("CREATE TABLE " + MEDIA + " (" + MEDIAID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HIVEID + " INTEGER NOT NULL, " + HIVEIMAGESTR + " VARCHAR, " + HIVEVIDEOSTR + " VARCHAR, " +
					   " FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE )");

			//Inspection Table
			db.execSQL("CREATE TABLE " + INSPECTION + " ( " + INSPECTIONID + " INTEGER PRIMARY KEY, " + DATEOFINSPECTION + " VARCHAR, " + HIVEBEHAVIOUR + " VARCHAR, " + OBSERVATION + " VARCHAR, " +
					   " " + CONCERN + " VARCHAR, " + HIVEID + " INTEGER NOT NULL, FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE )");

			//Treatment Table
			db.execSQL("CREATE TABLE " + TREATMENT + " (" + TREATMENTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TREATMENTAPPLIED + " VARCHAR, " + CONCERNS + " VARCHAR, " + INSPECTIONID + " INTEGER NOT NULL, " +
					   " FOREIGN KEY (inspectionID) REFERENCES Inspection(inspectionID) ON DELETE CASCADE )");

			//Pest Table
			db.execSQL("CREATE TABLE " + PEST + " (" + PESTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PESTSEEN + " VARCHAR, " + PESTMANAGEMENT + " VARCHAR, " + INSPECTIONID + " INTEGER NOT NULL, " +
					   " FOREIGN KEY (inspectionID) REFERENCES Inspection(inspectionID) ON DELETE CASCADE )");


		}

		@Override
		public void onUpgrade(SQLiteDatabase db,
							  int oldVersion, int newVersion) {

			db.execSQL("DROP TABLE \"Yard\"");
			Log.d("Apiary DB", "Upgrading db from version "
					+ oldVersion + " to " + newVersion);

			onCreate(db);
		}
	}

	private SQLiteDatabase db;
	private DBHelper dbHelper;

	// constructor
	public ApiaryDB(Context context) {
		dbHelper = new DBHelper(context, DATABASE_FILE_PATH + File.separator + "BeeApiaryData" + File.separator + DB_NAME, null, DB_VERSION);
		openWriteableDB();
		closeDB();
	}
	// private methods
	private void openReadableDB() {
		db = dbHelper.getReadableDatabase();
	}

	private void openWriteableDB() {
		db = dbHelper.getWritableDatabase();
	}

	private void closeDB() {
		if (db != null)
			db.close();
	}

	//Inserters
	public void addFlower(FlowerObj flower) {
		ContentValues contentvalues = new ContentValues();
		contentvalues.put(FLOWERID, flower.getFlowerID());
		contentvalues.put(YARDID, flower.getYardID());
		contentvalues.put(COMMONNAME, flower.getCommonName());
		contentvalues.put(SCIENTIFICNAME, flower.getScientificName());
		contentvalues.put(STARTOFSEASON, flower.getStartofSeason());
		contentvalues.put(ENDOFSEASON, flower.getEndofSeason());

		openWriteableDB();
		db.insert(FLOWER, null, contentvalues);
		closeDB();
	}

	public void addYard(YardObj yard) {
		ContentValues contentvalues = new ContentValues();
		contentvalues.put(LOCATION, yard.getLocation());
		contentvalues.put(LANDDESCRIPTION, yard.getLandDescription());

		openWriteableDB();
		db.insert(YARD, null, contentvalues);
		closeDB();
	}

	public void addQueen(QueenObj queen) {
		ContentValues contentvalues = new ContentValues();
		contentvalues.put(QUEENBIRTH, queen.getQueenBirth());
		contentvalues.put(QUEENREPLACED, queen.getQueenReplaced());
		contentvalues.put(HIVEID, queen.getHiveID());

		openWriteableDB();
		db.insert(QUEEN, null, contentvalues);
		closeDB();
	}

	public void addHive(HiveObj hive) {
		ContentValues contentvalues = new ContentValues();
		contentvalues.put(HIVENAME, hive.getHiveName());
		contentvalues.put(SPLITTYPE, hive.getSplitType());
		contentvalues.put(HIVETYPE, hive.getHiveType());
		contentvalues.put(YEARBEESWERESOURCED, hive.getYearbeeswereSourced());
		contentvalues.put(HIVECONFIGURATION, hive.getHiveConfiguration());
		contentvalues.put(YARDID, hive.getYardID());

		openWriteableDB();
		db.insert(HIVE, null, contentvalues);
		closeDB();
	}

	public void addHiveBox(BoxObj box) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(BOXTYPE, box.getBoxType());
		contentValues.put(NUMBEROFFRAMES, box.getNumberofFrames());
		contentValues.put(FRAMEMATERIAL, box.getFrameMaterial());
		contentValues.put(INSTALLATIONDATE, box.getInstallationDate());
		contentValues.put(HARVESTDATE, box.getHarvestDate());
		contentValues.put(HONEYWEIGHT, box.getHoneyWeight());
		contentValues.put(HIVEID, box.getHiveID());

		openWriteableDB();
		db.insert(BOX, null, contentValues);
		closeDB();
	}

	public void snapMedia(MediaObj media) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(HIVEID, media.getHiveID());
		contentValues.put(HIVEIMAGESTR,media.getHiveImageStr());
		contentValues.put(HIVEVIDEOSTR, media.getHiveVideoStr());

		openWriteableDB();
		db.insert(MEDIA, null, contentValues);
		closeDB();

	}

	public void addInspection(InspectionObj inspection) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DATEOFINSPECTION, inspection.getDateofInspection());
		contentValues.put(HIVEBEHAVIOUR, inspection.getHiveBehaviour());
		contentValues.put(OBSERVATION, inspection.getObservation());
		contentValues.put(CONCERN, inspection.getConcern());
		contentValues.put(HIVEID, inspection.getHiveID());

		openWriteableDB();
		db.insert(INSPECTION, null, contentValues);
		closeDB();
	}

	public void addTreatment(TreatmentObj treatment) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(TREATMENTAPPLIED, treatment.getTreatmentapplied());
		contentValues.put(CONCERNS, treatment.getConcerns());
		contentValues.put(INSPECTIONID, treatment.getInspectionID());

		openWriteableDB();
		db.insert(TREATMENT, null, contentValues);
		closeDB();
	}

	public void addPest(PestObj pest) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(PESTSEEN, pest.getPestSeen());
		contentValues.put(PESTMANAGEMENT, pest.getPestManagement());
		contentValues.put(INSPECTIONID, pest.getInspectionID());

		openWriteableDB();
		db.insert(PEST, null, contentValues);
		closeDB();
	}

}
