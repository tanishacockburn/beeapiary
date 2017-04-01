package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecordList extends AppCompatActivity {
    public Button btn_record_list_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
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
}
