package com.example.vincent.test2;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

public class MainActivity extends AppCompatActivity {

    private ImageView testImage;

    private String imageUrl = "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadImage();
    }

    private void initViews() {
        testImage = (ImageView) findViewById(R.id.test_image);
    }

    private void loadImage() {

        ImageLoader.getInstance().loadImage(imageUrl, new ImageLoadingListener() {

            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Log.d("Vincent", "onLoadingStarted");
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Log.d("Vincent", "onLoadingFailed");
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Log.d("Vincent", "onLoadingComplete");
                testImage.setImageBitmap(loadedImage);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                Log.d("Vincent", "onLoadingCancelled");
            }
        });
    }
}
