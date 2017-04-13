package com.example.tanisha.busy_bees_capstone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditQueen extends AppCompatActivity {
    Button btn_confirm;
    Button btn_edit_queen_cancel;
    Button btn_edit_queen_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_queen);

        btn_confirm = (Button) findViewById(R.id.btnReplaceQueenConfirm);
        btn_edit_queen_cancel = (Button) findViewById(R.id.btnEditQueenEdit);
        btn_edit_queen_back = (Button) findViewById(R.id.btnEditQueenBack);
        final EditText txt_queen_birth = (EditText) findViewById(R.id.txtQueenBirth);
        final EditText txt_date_queen_replaced = (EditText) findViewById(R.id.txtQueenReplaced);
        btn_edit_queen_cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt_queen_birth.setText("");
                        txt_date_queen_replaced.setText("");
                        Intent EditCancel = new Intent(EditQueen.this, Queen.class);
                        startActivity(EditCancel);
                    }
                });
        btn_edit_queen_back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent QueeneBack = new Intent(EditQueen.this, Queen.class);
                        startActivity(QueeneBack);
                    }
                });
    }
}

