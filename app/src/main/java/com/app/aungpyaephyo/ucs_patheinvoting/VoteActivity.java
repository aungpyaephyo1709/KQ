package com.app.aungpyaephyo.ucs_patheinvoting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class VoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button vote;
    TextView title;
    ImageView imageView;
    String type="";
    String select="";
    String b1=Global.b1.name;
    String b2=Global.b2.name;
    String b3=Global.b3.name;
    String b4=Global.b4.name;
    String b5=Global.b5.name;
    String b6=Global.b6.name;
    String b7=Global.b7.name;
    String b8=Global.b8.name;
    String b9=Global.b9.name;
    String b10=Global.b10.name;
    String b11=Global.b11.name;
    String g1=Global.g1.name;
    String g11=Global.g11.name;
    String g3=Global.g3.name;
    String g4=Global.g4.name;
    String g5=Global.g5.name;
    String g6=Global.g6.name;
    String g7=Global.g7.name;
    String g8=Global.g8.name;
    String g9=Global.g9.name;
    String g10=Global.g10.name;
    String[] boys={b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11};
    String[] girls={g1,g3,g4,g5,g6,g7,g8,g9,g10,g11};
    String[] current_title ={"King","Style Boy","Innocent Boy","Queen","Style Girl","Innocent Girl"};
    String ct=current_title[0];
    String current_gender="male";
    String[] result=new String[6];
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vote);

        imageView = findViewById(R.id.image);

        title=findViewById(R.id.text);

//        Bundle bundle=getIntent().getExtras();
//        type=bundle.getString("type");
//        select=bundle.getString("select");

        addItemsOnSpinner();

        addListenerOnButton();

        addListenerOnSpinnerItemSelection();

    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        if(parent.getItemAtPosition(pos).equals(b1)){
            Glide.with(this).load(R.drawable.b1_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b2)){
            Glide.with(this).load(R.drawable.b2_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b3)){
            Glide.with(this).load(R.drawable.b3_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b4)){
            Glide.with(this).load(R.drawable.b4_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b5)){
            Glide.with(this).load(R.drawable.b5_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b6)){
            Glide.with(this).load(R.drawable.b6_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b7)){
            Glide.with(this).load(R.drawable.b7_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b8)){
            Glide.with(this).load(R.drawable.b8_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b9)){
            Glide.with(this).load(R.drawable.b9_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b10)){
            Glide.with(this).load(R.drawable.b10_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b11)){
            Glide.with(this).load(R.drawable.b11_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g1)){
            Glide.with(this).load(R.drawable.g1_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g11)){
            Glide.with(this).load(R.drawable.g11_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g3)){
            Glide.with(this).load(R.drawable.g3_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g4)){
            Glide.with(this).load(R.drawable.g4_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g5)){
            Glide.with(this).load(R.drawable.g5_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g6)){
            Glide.with(this).load(R.drawable.g6_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g7)){
            Glide.with(this).load(R.drawable.g7_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g8)){
            Glide.with(this).load(R.drawable.g8_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g9)){
            Glide.with(this).load(R.drawable.g9_2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g10)){
            Glide.with(this).load(R.drawable.g10_2).fitCenter().into(imageView);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = findViewById(R.id.name);
        spinner.setOnItemSelectedListener(this);

    }
        // get the selected dropdown list value
        public void addListenerOnButton () {
            vote = findViewById(R.id.vote);
            vote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(spinner.getSelectedItemPosition()==0){
                        Toast.makeText(VoteActivity.this,"Please select someone",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (ct.equals("Innocent Girl")) {
                            Glide.with(VoteActivity.this).load(R.drawable.splah_welcome).fitCenter().into(imageView);
                            String str = spinner.getSelectedItem().toString();
                            result[index] = ct + "," + str;
                            final String r=result[0]+":"+result[1]+":"+result[2]+":"+result[3]+":"+result[4]+":"+result[5];
                            new AlertDialog.Builder(VoteActivity.this)
                                    .setMessage(result[0]+"\n"+result[1]+"\n"+result[2]+"\n"+result[3]+"\n"+result[4]+"\n"+result[5])
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            //firebase
                                            final ProgressDialog d = ProgressDialog.show(VoteActivity.this, "",
                                                    "Loading. Please wait...", true);
                                            FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getEmail()).setValue(r)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        d.dismiss();
                                                        Toast.makeText(VoteActivity.this, "Voting Successful", Toast.LENGTH_SHORT).show();
                                                        FirebaseAuth.getInstance().signOut();
                                                        finish();
                                                        startActivity(new Intent(VoteActivity.this, MainActivity.class));
                                                    }
                                                    else{
                                                        d.dismiss();
                                                        Toast.makeText(VoteActivity.this, "Voting Error\nPlease try again", Toast.LENGTH_LONG).show();
                                                        finish();
                                                        startActivity(new Intent(VoteActivity.this, VoteActivity.class));
                                                    }
                                                }
                                            });
                                        }
                                    })
                                    .setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                            startActivity(new Intent(VoteActivity.this, VoteActivity.class));
                                        }
                                    }).show();
                        } else {
                            Glide.with(VoteActivity.this).load(R.drawable.splah_welcome).fitCenter().into(imageView);
                            String str = spinner.getSelectedItem().toString();
                            result[index] = ct + "," + str;

                            Toast.makeText(VoteActivity.this,
                                    result[index],
                                    Toast.LENGTH_SHORT).show();

                            if (current_gender.equals("male")) {
                                for (int i = 0; i < boys.length; i++) {
                                    if (boys[i].equals(str)) {
                                        boys[i] = "";
                                    }
                                }
                            } else {
                                for (int i = 0; i < girls.length; i++) {
                                    if (girls[i].equals(str)) {
                                        girls[i] = "";
                                    }
                                }
                            }

                            index++;
                            ct = current_title[index];
                            if (ct.equals("Queen"))
                                current_gender = "female";
                            title.setText("Who is your " + ct);
                            addItemsOnSpinner();
                        }
                    }

                }
            });
        }

        public void addItemsOnSpinner () {
            List<String> list=new ArrayList<String>();
            spinner=findViewById(R.id.name);
            list.add("Choose your "+ ct);
            if(current_gender.equals("male")) {
                for (String boy : boys) {
                    if(boy.length()>0)
                    list.add(boy);
                }
            }
            else{
                for (String girl : girls) {
                    if(girl.length()>0)
                    list.add(girl);
                }
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
        }

}