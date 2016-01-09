package com.massivcode.intentexam3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText id, pw;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.id);
        pw = (EditText) findViewById(R.id.pw);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("id", id.getText().toString());
        intent.putExtra("pw", pw.getText().toString());

        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1000) {
            if(resultCode == RESULT_OK) {
                if(data != null) {
                    Toast.makeText(MainActivity.this, "받은 데이터 : " + data.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
