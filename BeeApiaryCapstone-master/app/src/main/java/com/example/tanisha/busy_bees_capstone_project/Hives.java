package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Hives extends AppCompatActivity {
    Button btn_add_hive ;
    ListView listView;
    ArrayAdapter<String>adapter;
    String hives[]={"Hive 1","Hive 2","Hive 3","Hive 4"};
    SearchView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hives);
        AddHivesPage();
        ListOfHives();

    }

    public void ListOfHives() {
        listView=(ListView)findViewById(R.id.hivesListView) ;
        adapter= new ArrayAdapter(this, R.layout.hive_list, hives);
        listView.setAdapter(adapter);
        //sv=(SearchView)findViewById(R.id.searchView);


        /*sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }*/

//            @Override
//            public boolean onQueryTextChange(String text) {
//
//                adapter.getFilter().filter(text);
//                return false;
//            }
//        });


    }
    public  void AddHivesPage()
    {
        btn_add_hive=(Button)findViewById(R.id.btnAddHive);
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


        switch (item.getItemId()){
            case R.id.activityHome:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent homePage = new Intent(Hives.this, MainActivity.class);
                startActivity(homePage);

                break;
            case R.id.activity_hives:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent hivesPage = new Intent(Hives.this, Hives.class);
                startActivity(hivesPage);

                break;
            case R.id.activity_records:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent recordPage = new Intent(Hives.this, Records.class);
                startActivity(recordPage);

                break;
            case R.id.activity_new_record:
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent newRecordPage = new Intent(Hives.this, NewRecord.class);
                startActivity(newRecordPage);

                break;




        }



        return super.onOptionsItemSelected(item);
    }
}
