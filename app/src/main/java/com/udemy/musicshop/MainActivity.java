package com.udemy.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //
    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMap();
        createSpinner();

        userNameEditText = findViewById(R.id.nameEditText);
    }

    void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap(){
        goodsMap = new HashMap();
        goodsMap.put("guitar", 100.00);
        goodsMap.put("drums", 200.00);
        goodsMap.put("keyboard", 300.00);
    }

    public void quantityMinus(View view) {
        quantity = quantity - 1;
        if (quantity < 0){
            quantity = 0;
        }
        TextView minusTextView = findViewById(R.id.quantityTextView);
        minusTextView.setText("" + quantity);
        TextView priceTextView =findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void quantityPlus(View view) {
        quantity = quantity + 1;
        TextView plusTextView = findViewById(R.id.quantityTextView);
        plusTextView.setText("" + quantity);
        TextView priceTextView =findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        switch (goodsName){
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                goodsImageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCart(View view) {

        Order order = new Order();
        order.userName = userNameEditText.getText().toString();
        order.goodsName = goodsName;
        order.quantity = quantity;
        order.orderPrice = quantity * price;

        Log.d("userName", order.userName);
        Log.d("goodsName", order.goodsName);
        Log.d("quantityName", "" + order.quantity);
        Log.d("orderPriceName", "" + order.orderPrice);
    }
}
