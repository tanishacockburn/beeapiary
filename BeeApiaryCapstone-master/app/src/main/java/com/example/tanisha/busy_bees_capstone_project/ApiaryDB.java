package com.example.tanisha.busy_bees_capstone_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ApiaryDB {

    public static final String DB_NAME = "apiary.db";
    public static final int DB_VERSION = 1;

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // create tables

            //Set fk constraints
            db.execSQL("PRAGMA foreign_keys = ON");


            //Flower table
            db.execSQL("CREATE TABLE Flower (flowerID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    " yardID INTEGER, commonName VARCHAR NOT NULL, scientificName VARCHAR,  " +
                    " startofSeason VARCHAR, endofSeason VARCHAR, " +
                    " FOREIGN KEY (yardID) REFERENCES Yard(yardID) ON DELETE CASCADE)");

            //Yard table
            db.execSQL("CREATE TABLE Yard (yardID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    " location VARCHAR NOT NULL, landDescription VARCHAR )");
            //Hive
            db.execSQL("CREATE TABLE Hive (hiveID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, hiveName VARCHAR, splitType VARCHAR, hiveType VARCHAR " +
                       "numberofBoxes INTEGER, boxes VARCHAR, yearbeeswereSourced INTEGER, hiveConfiguration VARCHAR, yardID INTEGER, " +
                       " FOREIGN KEY (yardID) REFERENCES Yard(yardID) ON DELETE CASCADE )");

            //Queen table
            db.execSQL("CREATE TABLE Queen (queenID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, queenBirth VARCHAR, queenReplaced VARCHAR, hiveID INTEGER NOT NULL, " +
                       "FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE)");

            //Box table
            db.execSQL("CREATE TABLE Box (boxID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, boxType VARCHAR, numberofFrames INTEGER, frameMaterial VARCHAR, " +
                       " installationDate VARCHAR, harvestDate VARCHAR, honeyWeight DECIMAL(5, 3), hiveID INTEGER NOT NULL, " +
                       " FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE )");

            //Media Table
            db.execSQL("CREATE TABLE Media (mediaID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, hiveID INTEGER NOT NULL, hiveImageStr VARCHAR, hiveVideoStr VARCHAR, " +
                       " FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE )");

            //Inspection Table
            db.execSQL("CREATE TABLE Inspection ( inspectionID INTEGER PRIMARY KEY NOT NULL, dateofInspection VARCHAR, hiveBehaviour VARCHAR, observation VARCHAR, " +
                       " concern VARCHAR, hiveID INTEGER NOT NULL, FOREIGN KEY (hiveID) REFERENCES Hive(hiveID) ON DELETE CASCADE )");

            //Treatment Table
            db.execSQL("CREATE TABLE Treatment (treatmentID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, treatment VARCHAR, concerns VARCHAR, inspectionID INTEGER NOT NULL, " +
                       " FOREIGN KEY (inspectionID) REFERENCES Inspection(inspectionID) ON DELETE CASCADE )");

            //Pest Table
            db.execSQL("CREATE TABLE Pest (pestID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pest VARCHAR, pestManagement VARCHAR, inspectionID INTEGER NOT NULL, " +
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
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
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
}
