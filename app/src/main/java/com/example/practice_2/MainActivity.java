package com.example.practice_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner type1, type2;
    private EditText enter;
    private Button buttonConv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter = (EditText) findViewById(R.id.editText2);
        buttonConv = (Button) findViewById(R.id.buttonConv);

        type1 = (Spinner) findViewById(R.id.type1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currency1));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type1.setAdapter(myAdapter1);

        type2 = (Spinner) findViewById(R.id.type2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currency2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type2.setAdapter(myAdapter2);

    }

    public void onClick(View view) {
        int spin1 = type1.getSelectedItemPosition();
        int spin2 = type2.getSelectedItemPosition();
        float value = Float.parseFloat(enter.getText().toString());

        float ratio[] = {1.0f, 0.0140334f, 0.0126525f};
        float result = value / ratio[spin1] * ratio[spin2];
        Toast.makeText(MainActivity.this,Float.toString(result),Toast.LENGTH_LONG).show();
    }
}
