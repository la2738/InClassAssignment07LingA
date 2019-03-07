package com.example.android.inclassassignment07_linga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity {
    EditText mFriName,mFriAge,mFriInfo;
    CheckBox mEatSweets;
    RadioGroup g1;
    String canDrinkAlcohol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initializeViewControls();

        g1 =(RadioGroup) findViewById(R.id.radioGroup);
        g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.adult_radioButton){
                    canDrinkAlcohol = "Yes!!!";
                }
                if(checkedId==R.id.minor_radioButton){
                    canDrinkAlcohol = "Not yet!!!";
                }
            }
        });
    }

    private void initializeViewControls(){
        mFriName = findViewById(R.id.friNmae);
        mFriAge = findViewById(R.id.friAge);
        mFriInfo = findViewById(R.id.friInfo);
        mEatSweets = findViewById(R.id.sweets_checkBox);
    }

    public void submitFriend(View view) {
        String friName = mFriName.getText().toString();
        int friAge = Integer.valueOf(mFriAge.getText().toString());
        String friInfo = mFriInfo.getText().toString();
        boolean eatSweets = mEatSweets.isChecked();

        Friend fri = new Friend(friName,friInfo,friAge,eatSweets,canDrinkAlcohol);
        Intent data = new Intent();
        data.putExtra(Keys.FRIEND, fri);
        setResult(RESULT_OK, data);
        finish();
    }

}
