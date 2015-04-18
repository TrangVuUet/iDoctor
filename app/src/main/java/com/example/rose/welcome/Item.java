package com.example.rose.welcome;

import android.graphics.Bitmap;

/**
 * Created by Rose on 4/16/2015.
 */
public class Item {
    Bitmap image;
    String title;

    public Item(Bitmap image, String title) {
        this.image = image;
        this.title = title;
    }

    public  Bitmap getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
