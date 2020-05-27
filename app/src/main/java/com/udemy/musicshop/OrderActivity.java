package com.udemy.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"admin@bzv.com.ua"};
    String subject = "Order from Music Shop";
    String emailText;

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
        emailText = "Customer name: " + userName +"\n" +
                "Goods name: " + goodsName + "\n" +
                "Quantity: "+ quantity + "\n" +
                "Price: "+ priceForIntent + "\n" +
                "Order Price: "+ orderPriceForIntent;

        TextView userNameText = findViewById(R.id.orderTextView);
        userNameText.setText(emailText);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
