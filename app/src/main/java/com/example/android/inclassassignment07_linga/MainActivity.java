package com.example.android.inclassassignment07_linga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFriends(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, RequestCodes.ADD_PERSON);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCodes.ADD_PERSON && resultCode == RESULT_OK) {
            Friend fri = (Friend) data.getSerializableExtra(Keys.FRIEND);

            TextView res =(TextView)findViewById(R.id.textView);
            res.setText(fri.toString());
        }
    }


}
