package com.example.tanisha.busy_bees_capstone_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceQueen extends AppCompatActivity {

    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_queen);
        final EditText txt_queen_birth = (EditText) findViewById(R.id.txtQueenBirth);
        final EditText txt_date_queen_replaced = (EditText) findViewById(R.id.txtQueenReplaced);
        btn_confirm = (Button) findViewById(R.id.btnReplaceQueenConfirm);


        btn_confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        if (!validDate(txt_queen_birth.getText().toString())) {
                            txt_queen_birth.setError("Please insert a date YYYY/MM/DD");
                            txt_queen_birth.requestFocus();
                        }
                        if (txt_date_queen_replaced.getText().length() > 0) {
                            if (!validDate(txt_date_queen_replaced.getText().toString())) {
                                txt_date_queen_replaced.setError("Please insert a date YYYY/MM/DD");
                                txt_date_queen_replaced.requestFocus();
                            }
                        }
                        if(validDate(txt_queen_birth.getText().toString()) && (validDate(txt_date_queen_replaced.getText().toString())|| txt_date_queen_replaced.getText().length()==0)) {
                            Toast.makeText(ReplaceQueen.this, "Queen added", Toast.LENGTH_LONG).show();
                        }

                    }

                    private boolean validDate(String date) {
                        String date_pattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
                        Pattern pattern = Pattern.compile(date_pattern);
                        Matcher matcher = pattern.matcher(date);
                        return matcher.matches();
                    }
                });
    }

}
