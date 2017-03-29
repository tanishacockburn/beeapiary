package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Queen extends AppCompatActivity {
    Button btn_replace_queen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queen);
        btn_replace_queen=(Button)findViewById(R.id.btnReplaceQueen);
        ReplaceQueenPage();
    }

    private void ReplaceQueenPage() {
        {

            btn_replace_queen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent replaceQueen = new Intent(Queen.this, ReplaceQueen.class);
                    startActivity(replaceQueen);

                }
            });
        }
    }
}
