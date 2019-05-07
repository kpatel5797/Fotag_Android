// I have referred to the following video to get the idea of how to make this file:
// https://www.youtube.com/watch?v=Il3uB5u2pSA

// Parts of code may be taken from the class example

package a4.a4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class FullScreen extends AppCompatActivity {

    Model model;
    String imageUrl;
    Bitmap bitImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_image);
        model = Model.getInstance();
        Bundle b = getIntent().getExtras();
        imageUrl = b.getString("URL");

        ImageView img = findViewById(R.id.full_image);
        new getImage(img).execute(imageUrl);

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private class getImage extends AsyncTask<String, Void, Bitmap> {
        ImageView iv;

        public getImage(ImageView iv) {
            this.iv = iv;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String imgUrl = url[0];
            bitImage = null;
            try {
                InputStream in = new java.net.URL(imgUrl).openStream();
                bitImage = BitmapFactory.decodeStream(in);
            }
            catch (Exception e) {
                Log.e("ERROR", e.getMessage());
                e.printStackTrace();
            }
            return bitImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
        }
    }
}
