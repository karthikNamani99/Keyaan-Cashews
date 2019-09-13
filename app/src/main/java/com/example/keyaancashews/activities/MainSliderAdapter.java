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
                viewHolder.bindImageSlide("http://keyitsol.com/keyaancashews/uploads/banners/b96f63f9120b98104bd36494215ae38b.jpg");
                break;
            case 1:
                viewHolder.bindImageSlide("http://keyitsol.com/keyaancashews/uploads/banners/d01e3c0214c7451b59b034b6d58ce4e5.jpg");
                break;
            case 2:
                viewHolder.bindImageSlide("http://keyitsol.com/keyaancashews/uploads/banners/6089dee9a3cb70e767f26b49e5c27c65.jpg");
                break;
        }
    }
}
