package com.app.aungpyaephyo.ucs_patheinvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class DetailSelectionActivity extends AppCompatActivity {

    ImageView img;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_selection);

        img=findViewById(R.id.dimage);
        text=findViewById(R.id.text);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("Student");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);

                Log.d("Details-->", jo_inside.getString("Name"));

                String jsonName = jo_inside.getString("Name");
                String img1=jo_inside.getString("photo1");

                if (jsonName.equals(name))
                {
                    int id = getResources().getIdentifier(img1,"drawable",getPackageName());
                    Drawable drawable = getResources().getDrawable(id);
                    img.setImageDrawable(drawable);
                    text.setText(id);
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("selection.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
