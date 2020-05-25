package com.udemy.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("You order: ");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = receivedOrderIntent.getStringExtra("goodsNameForIntent");
        int quantity = receivedOrderIntent.getIntExtra("quantityForIntent", 0);
        double orderPriceForIntent = receivedOrderIntent.getDoubleExtra("orderPriceForIntent", 0);
        double priceForIntent = receivedOrderIntent.getDoubleExtra("priceForIntent", 0);
        TextView userNameText = findViewById(R.id.orderTextView);
        userNameText.setText("Customer name: " + userName +
                "\n Goods name: "+ goodsName +
                "\n Quantity: "+ quantity +
                "\n Price: "+ priceForIntent +
                "\n Order Price: "+ orderPriceForIntent);

    }
}
