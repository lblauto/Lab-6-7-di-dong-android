package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText outputText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.outputText = (EditText) this.findViewById(R.id.editText);
        this.button = (Button) this.findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runExample(view);
            }
        });
    }

    private void runExample(View view) {
        try{
            Company company = ReadJSON.readCompanyJSONFile(this);
            String s = company.toString();
            outputText.setText(s);
        }
        catch (IOException | JSONException e){
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}