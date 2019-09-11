package com.example.keyaancashews.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keyaancashews.R;
import com.example.keyaancashews.adapters.SubCategoryAdapter;
import com.example.keyaancashews.entities.ProductObject;
import com.example.keyaancashews.helpers.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class SubCategoryList extends AppCompatActivity {

    private static final String TAG = ShoppingActivity.class.getSimpleName();

    private RecyclerView shoppingRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity_shopping);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        shoppingRecyclerView = (RecyclerView)findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(SubCategoryList.this, 2);
        shoppingRecyclerView.setLayoutManager(mGrid);
        shoppingRecyclerView.setHasFixedSize(true);
        shoppingRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));

        SubCategoryAdapter shopAdapter = new SubCategoryAdapter(SubCategoryList.this, getAllProductsOnSale());
        shoppingRecyclerView.setAdapter(shopAdapter);
    }


    private List<ProductObject> getAllProductsOnSale(){
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1 , "W - 180", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "W - 210", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Good"));
        products.add(new ProductObject(1, "W - 240", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Normal"));
        products.add(new ProductObject(1, "W - 320", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "W - 450", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "W - 500", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
       /* products.add(new ProductObject(1, "Cashew", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "Cashew", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "Cashew", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
*/
        return products;
    }
}
