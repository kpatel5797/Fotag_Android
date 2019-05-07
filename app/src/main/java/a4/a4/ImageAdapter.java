// I have referred to the following website and video to get the idea of how to make this file:
// https://abhiandroid.com/ui/baseadapter-tutorial-example.html
// https://www.youtube.com/watch?v=Il3uB5u2pSA

// Parts of code may be taken from the class example

package a4.a4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.*;
import android.view.*;
import android.content.Context;
import android.content.Intent;
import java.util.Vector;

import java.io.InputStream;

public class ImageAdapter extends BaseAdapter {
    Context context;
    Vector <String>imageUrls;
    LayoutInflater inflater;
    Bitmap bitImage;
    Model model;

    public ImageAdapter(Context applicationContext, Vector<String> imageUrls) {
        this.context = applicationContext;
        this.imageUrls = imageUrls;
        model = Model.getInstance();
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object getItem(int i) {
        return imageUrls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final String url = imageUrls.get(i);
        view = inflater.inflate(R.layout.image_view, null);
        final ImageView img = view.findViewById(R.id.image);
        final RatingBar ratingBar = view.findViewById(R.id.rating_bar);
        new getImage(img).execute(url);
        ratingBar.setRating((model.getMyRatings()).get(i));

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                model.setFullImageUrl(url);
                imageClick();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                (model.getMyRatings()).set(i, rating);
                model.setBarRating(i, rating);
                if(model.getFilter() != 0 && rating < model.getFilter()) {
                    (model.getMyUrls()).remove(i);
                    (model.getMyRatings()).remove(i);
                    ImageAdapter imageAdapter = new ImageAdapter(context, model.getMyUrls());
                    (model.getGrid()).setAdapter(imageAdapter);
                }
            }
        });

        return view;
    }

    public void imageClick() {
        Intent intent = new Intent(context, FullScreen.class);
        intent.putExtra("URL", model.getFullImgUrl());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        Toast t = Toast.makeText(this.context,"Clicked", Toast.LENGTH_SHORT);
        t.show();
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
