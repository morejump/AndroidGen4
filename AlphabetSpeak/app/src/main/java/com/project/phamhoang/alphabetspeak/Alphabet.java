package com.project.phamhoang.alphabetspeak;

import android.widget.ImageButton;

/**
 * Created by phamhoang on 8/22/16.
 */
public class Alphabet {
    private ImageButton imageButton;

    public Alphabet() {

    }

    public Alphabet(ImageButton imageButton) {
        this.imageButton = imageButton;
    }


    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }
}
