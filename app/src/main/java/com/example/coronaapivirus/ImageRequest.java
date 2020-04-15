package com.example.coronaapivirus;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ImageRequest extends AsyncTask<String, Void, Bitmap> {
    ImageView resimImage;

    public ImageRequest(ImageView resimImage) {

        this.resimImage = resimImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new java.net.URL(urldisplay).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            Log.e("Hata :", e.getMessage());
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        resimImage.setImageBitmap(result);
    }







}
