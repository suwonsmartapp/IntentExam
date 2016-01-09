package com.massivcode.intentexam3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button customer, sales, goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        customer = (Button) findViewById(R.id.btn_customer);
        sales = (Button) findViewById(R.id.btn_sales);
        goods = (Button) findViewById(R.id.btn_goods);

        customer.setOnClickListener(this);
        sales.setOnClickListener(this);
        goods.setOnClickListener(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        Toast.makeText(Main2Activity.this, "아이디 : " + id + " , 패스워드 : " + pw , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btn_customer:
                intent.putExtra("msg", customer.getText().toString());
                break;
            case R.id.btn_sales:
                intent.putExtra("msg", sales.getText().toString());
                break;
            case R.id.btn_goods:
                intent.putExtra("msg", goods.getText().toString());
                break;
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}
