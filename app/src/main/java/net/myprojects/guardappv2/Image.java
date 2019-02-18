package net.myprojects.guardappv2;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gilberto17-PC on 21/02/2018.
 */

public class Image {
    //get image from URL
    public static Drawable fromUrl(String url) {
        //define object
        Drawable d = null;
        try {
            InputStream data = (InputStream)new URL(url).getContent();
            d = Drawable.createFromStream(data,"");
        }catch (MalformedURLException ex) {
            Log.e("Error", ex.getMessage());
        } catch (IOException ex) {
            Log.e("Error", ex.getMessage());
        }
            //return drawable object
            return d;
    }
}
