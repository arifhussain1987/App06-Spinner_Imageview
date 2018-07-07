package com.example.arifa.spinnerimageview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView myimage;
    Spinner myspinner;
    ArrayAdapter<CharSequence> adapter;
    TextView txtresult;

    LinearLayout mylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myimage = findViewById(R.id.imgview);
        myimage.setImageResource(R.drawable.flag1);

        myspinner = findViewById(R.id.myspinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);

        txtresult = findViewById(R.id.txtshowspinnervalue);
        mylayout = findViewById(R.id.layout);

        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // if we want first option as a hint then get the first position and set if condition
                int pos = adapterView.getSelectedItemPosition();    // this returns the position of first element
                if(pos != 0)
                {
                    String text = adapterView.getItemAtPosition(i).toString();
                    txtresult.setText(text);

                    switch (text)
                    {
                        case "Red":
                            mylayout.setBackgroundColor(Color.RED);
                            break;

                        case "Green":
                            mylayout.setBackgroundColor(Color.GREEN);
                            break;

                        case "Blue":
                            mylayout.setBackgroundColor(Color.BLUE);
                            break;
                    }
                }
                else {
                    txtresult.setText("");
                    mylayout.setBackgroundColor(Color.WHITE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
