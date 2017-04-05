package com.example.tanisha.busy_bees_capstone_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBox extends AppCompatActivity {

    EditText txt_box_type;
    EditText txt_number_of_frames;
    EditText txt_frame_material;
    EditText txt_honey_weight;
    EditText txt_installation_date;
    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_box);
        txt_box_type=(EditText)findViewById(R.id.txtBoxType);
        txt_number_of_frames=(EditText)findViewById(R.id.txtNumberOfFrames);
        txt_frame_material=(EditText)findViewById(R.id.txtFrameMaterial);
        txt_honey_weight=(EditText)findViewById(R.id.txtHoneyWeight);
        txt_installation_date=(EditText)findViewById(R.id.txtInstallationDate);
        btn_confirm=(Button)findViewById(R.id.btnReplaceQueenConfirm);
        SaveBox();
    }

    public void SaveBox() {
        btn_confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (txt_box_type.getText().length() == 0) {
                            txt_box_type.setError("please enter box type ");
                        }
                        if ( txt_number_of_frames.getText().length() == 0) {
                            txt_number_of_frames.setError("please enter number of frames ");
                        }
                        if (txt_frame_material.getText().length() == 0) {
                            txt_frame_material.setError("please enter frame material ");
                        }

                        if (txt_installation_date.getText().length() == 0) {
                            txt_installation_date.setError("please enter installation date");
                        }
                        if (txt_installation_date.getText().length() > 0) {
                            if (!validDate(txt_installation_date.getText().toString())) {
                                txt_installation_date.setError("Please insert  date YYYY/MM/DD");
                                txt_installation_date.requestFocus();
                            }
                        }

                        else

                            Toast.makeText(AddBox.this, "Box is saved ", Toast.LENGTH_LONG).show();
                    }
                    private boolean validDate(String date) {
                        String date_pattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
                        Pattern pattern = Pattern.compile(date_pattern);
                        Matcher matcher = pattern.matcher(date);
                        return matcher.matches();
                    }
                }
        );
    }
}
