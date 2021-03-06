package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Queen extends AppCompatActivity {
    Button btn_replace_queen;
    Button btn_edit_queen;
    Button btn_queen_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queen);
        btn_replace_queen = (Button) findViewById(R.id.btnEditQueenEdit);
        btn_edit_queen = (Button) findViewById(R.id.btnEditQueenEdit);
        ReplaceQueenPage();
        EditQueenPage();
        BackToMainPage();
    }

    private void BackToMainPage() {
        btn_queen_back = (Button) findViewById(R.id.btnEditQueenBack);
        btn_queen_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoMain = new Intent(Queen.this, MainActivity.class);
                startActivity(backtoMain);
            }
        });
    }

    private void EditQueenPage() {
        {
            btn_edit_queen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent editQueen = new Intent(Queen.this, EditQueen.class);
                    startActivity(editQueen);

                }
            });
        }
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
