package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.tv_show);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance()); //设置文本滚动


        try {
            JSONArray jsonarr = new JSONArray(message);
            for(int i = 0; i < jsonarr.length(); i++){
                JSONObject jsonobj = jsonarr.getJSONObject(i);
                String Name=jsonobj.getString("name");
                String Tel=jsonobj.getString("tel");
                textView.append("\n" + "Name：" + Name + " ; Tel：" + Tel+"\n");
            }
            } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
