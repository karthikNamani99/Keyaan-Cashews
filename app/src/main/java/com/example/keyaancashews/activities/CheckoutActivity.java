package com.example.keyaancashews.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keyaancashews.R;
import com.example.keyaancashews.adapters.CheckRecyclerViewAdapter;
import com.example.keyaancashews.entities.ProductObject;
import com.example.keyaancashews.helpers.MySharedPreference;
import com.example.keyaancashews.helpers.SimpleDividerItemDecoration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private static final String TAG = CheckoutActivity.class.getSimpleName();

    private RecyclerView checkRecyclerView;

    private TextView subTotal;

    private double mSubTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTitle("Over Cart");

        subTotal = (TextView)findViewById(R.id.sub_total);

        checkRecyclerView = (RecyclerView)findViewById(R.id.checkout_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CheckoutActivity.this);
        checkRecyclerView.setLayoutManager(linearLayoutManager);
        checkRecyclerView.setHasFixedSize(true);
        checkRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(CheckoutActivity.this));

        // get content of cart
        MySharedPreference mShared = new MySharedPreference(CheckoutActivity.this);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ProductObject[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(), ProductObject[].class);
        List<ProductObject> productList = convertObjectArrayToListObject(addCartProducts);

        CheckRecyclerViewAdapter mAdapter = new CheckRecyclerViewAdapter(CheckoutActivity.this, productList);
        checkRecyclerView.setAdapter(mAdapter);

        mSubTotal = getTotalPrice(productList);
        subTotal.setText("Subtotal excluding tax and shipping: " + String.valueOf(mSubTotal) + " $");


        Button shoppingButton = (Button)findViewById(R.id.shopping);
        assert shoppingButton != null;
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shoppingIntent = new Intent(CheckoutActivity.this, ShoppingActivity.class);
                startActivity(shoppingIntent);
            }
        });

        Button checkButton = (Button)findViewById(R.id.checkout);
        assert checkButton != null;
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentIntent = new Intent(CheckoutActivity.this, PayPalCheckoutActivity.class);
                paymentIntent.putExtra("TOTAL_PRICE", mSubTotal);
                startActivity(paymentIntent);
            }
        });
    }

    private List<ProductObject> convertObjectArrayToListObject(ProductObject[] allProducts){
        List<ProductObject> mProduct = new ArrayList<ProductObject>();
        Collections.addAll(mProduct, allProducts);
        return mProduct;
    }

    private int returnQuantityByProductName(String productName, List<ProductObject> mProducts){
        int quantityCount = 0;
        for(int i = 0; i < mProducts.size(); i++){
            ProductObject pObject = mProducts.get(i);
            if(pObject.getProductName().trim().equals(productName.trim())){
                quantityCount++;
            }
        }
        return quantityCount;
    }

    private double getTotalPrice(List<ProductObject> mProducts){
        double totalCost = 0;
        for(int i = 0; i < mProducts.size(); i++){
            ProductObject pObject = mProducts.get(i);
            totalCost = totalCost + pObject.getProductPrice();
        }
        return totalCost;
    }
}
