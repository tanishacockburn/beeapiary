package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Yard extends AppCompatActivity {
    public Button btn_add_yard ;
    public Button btn_edit_yard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yard);
        AddYardPage();
        EditYardPage();

    }

    private void AddYardPage() {
        btn_add_yard=(Button)findViewById(R.id.btbAddYard);
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
                Intent editYard = new Intent(Yard.this, EditYard.class);
                startActivity(editYard);

            }
        });
    }


}
