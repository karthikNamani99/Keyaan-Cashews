package com.example.keyaancashews.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keyaancashews.R;
import com.example.keyaancashews.adapters.ShopRecyclerViewAdapter;
import com.example.keyaancashews.entities.ProductObject;
import com.example.keyaancashews.helpers.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.Slider;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.event.OnSlideClickListener;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;


public class ShoppingActivity extends AppCompatActivity {

    Slider slider;

    private static final String TAG = ShoppingActivity.class.getSimpleName();

    private RecyclerView shoppingRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        slider = findViewById(R.id.banner_slider1);
        Slider.init(new PicassoImageLoadingService(this));

        slider = findViewById(R.id.banner_slider1);

        //delay for testing empty view functionality
        slider.postDelayed(new Runnable() {
            @Override
            public void run() {
                slider.setAdapter(new MainSliderAdapter());
                slider.setSelectedSlide(0);
            }
        }, 1500);

        slider.setOnSlideClickListener(new OnSlideClickListener() {
            @Override
            public void onSlideClick(int position) {


                switch (position) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), CheckoutActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);

                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), CheckoutActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);

                        break;
//            case 0:
//                viewHolder.bindImageSlide("http://keyitsol.com/keyaancashews/uploads/banners/b96f63f9120b98104bd36494215ae38b.jpg");
//                break;
//            case 1:
//                viewHolder.bindImageSlide("http://keyitsol.com/keyaancashews/uploads/banners/d01e3c0214c7451b59b034b6d58ce4e5.jpg");
//                break;
//            case 2:
//                viewHolder.bindImageSlide("http://keyitsol.com/keyaancashews/uploads/banners/6089dee9a3cb70e767f26b49e5c27c65.jpg");
//                break;
                }
            }
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        shoppingRecyclerView = (RecyclerView) findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(ShoppingActivity.this, 2);
        shoppingRecyclerView.setLayoutManager(mGrid);
        shoppingRecyclerView.setHasFixedSize(true);
        shoppingRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));

        ShopRecyclerViewAdapter shopAdapter = new ShopRecyclerViewAdapter(ShoppingActivity.this, getAllProductsOnSale());
        shoppingRecyclerView.setAdapter(shopAdapter);
    }


    private List<ProductObject> getAllProductsOnSale() {
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "WHITE WHOLES", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "SCORCHED WHOLES", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Good"));
        products.add(new ProductObject(1, "DESSERT WHOLES", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Normal"));
        products.add(new ProductObject(1, "WHITE PIECES", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "SCORCHED PIECES", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "DESSERT PIECES", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
       /* products.add(new ProductObject(1, "Cashew", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "Cashew", R.drawable.cashew, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
        products.add(new ProductObject(1, "Cashew", R.drawable.cashewone, "Raw Cashew Nut has a variety of nutrients such as unsaturated fatty acids, fiber, protein, vitamins, minerals, and antioxidants, which are vital for heart health. ", 850, 1, "Premium"));
*/
        return products;
    }


}
