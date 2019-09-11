package com.example.keyaancashews.activities;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {
    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {

            case 0:

                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg");
                break;

            case 1:

                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg");
                break;

            case 2:

                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png");
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
}
