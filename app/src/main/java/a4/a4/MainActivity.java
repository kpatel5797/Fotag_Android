// Parts of code may be taken from the class examples

package a4.a4;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Model model;
    GridView imageGrid;

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            imageGrid.setNumColumns(1);
        }
        else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageGrid.setNumColumns(2);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imageGrid = findViewById(R.id.image_grid);
        model = Model.getInstance();
        model.setGrid(imageGrid);

        if(model.getLoaded() == true) {
            orientationChange();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    public void orientationChange() {
        ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext(), model.getMyUrls());
        imageGrid.setAdapter(imageAdapter);
        modifyStar();
    }

    public void downloadClicked(View view) {
        clearClicked(view);
        model.setOriginal();
        ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext(), model.getMyUrls());
        imageGrid.setAdapter(imageAdapter);
        model.setLoaded(true);

        Toast toast = Toast.makeText(getApplicationContext(),"Images loaded", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void clearClicked(View view) {
        if(model.getLoaded() == true) {
            imageGrid = findViewById(R.id.image_grid);
            imageGrid.setAdapter(null);
            model.setDefaultRating();
            model.clearVectors();
            model.setFilter(0);
            modifyStar();
            model.setLoaded(false);

            Toast toast = Toast.makeText(getApplicationContext(), "Images cleared", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "No images", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void starClick(View view) {
        ImageButton star1 = findViewById(R.id.star_button_1);
        ImageButton star2 = findViewById(R.id.star_button_2);
        ImageButton star3 = findViewById(R.id.star_button_3);
        ImageButton star4 = findViewById(R.id.star_button_4);
        ImageButton star5 = findViewById(R.id.star_button_5);

        star1.setBackgroundResource(R.drawable.star_empty_icon);
        star2.setBackgroundResource(R.drawable.star_empty_icon);
        star3.setBackgroundResource(R.drawable.star_empty_icon);
        star4.setBackgroundResource(R.drawable.star_empty_icon);
        star5.setBackgroundResource(R.drawable.star_empty_icon);

        if(model.getLoaded() == true) {
            switch (view.getId()) {
                case R.id.star_button_1:
                    if (model.getFilter() != 1) {
                        star1.setBackgroundResource(R.drawable.star_filled_icon);
                        model.setFilter(1);
                        model.setMyVectors((float)1);
                    } else {
                        model.setFilter(0);
                        model.setOriginal();
                    }
                    break;

                case R.id.star_button_2:
                    if (model.getFilter() != 2) {
                        star1.setBackgroundResource(R.drawable.star_filled_icon);
                        star2.setBackgroundResource(R.drawable.star_filled_icon);
                        model.setFilter(2);
                        model.setMyVectors((float)2);
                    } else {
                        model.setFilter(0);
                        model.setOriginal();
                    }
                    break;

                case R.id.star_button_3:
                    if (model.getFilter() != 3) {
                        star1.setBackgroundResource(R.drawable.star_filled_icon);
                        star2.setBackgroundResource(R.drawable.star_filled_icon);
                        star3.setBackgroundResource(R.drawable.star_filled_icon);
                        model.setFilter(3);
                        model.setMyVectors((float)3);
                    } else {
                        model.setFilter(0);
                        model.setOriginal();
                    }
                    break;

                case R.id.star_button_4:
                    if (model.getFilter() != 4) {
                        star1.setBackgroundResource(R.drawable.star_filled_icon);
                        star2.setBackgroundResource(R.drawable.star_filled_icon);
                        star3.setBackgroundResource(R.drawable.star_filled_icon);
                        star4.setBackgroundResource(R.drawable.star_filled_icon);
                        model.setFilter(4);
                        model.setMyVectors((float)4);
                    } else {
                        model.setFilter(0);
                        model.setOriginal();
                    }
                    break;

                case R.id.star_button_5:
                    if (model.getFilter() != 5) {
                        star1.setBackgroundResource(R.drawable.star_filled_icon);
                        star2.setBackgroundResource(R.drawable.star_filled_icon);
                        star3.setBackgroundResource(R.drawable.star_filled_icon);
                        star4.setBackgroundResource(R.drawable.star_filled_icon);
                        star5.setBackgroundResource(R.drawable.star_filled_icon);
                        model.setFilter(5);
                        model.setMyVectors((float)5);
                    } else {
                        model.setFilter(0);
                        model.setOriginal();
                    }
                    break;
            }
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "No images", Toast.LENGTH_SHORT);
            toast.show();
        }

        ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext(), model.getMyUrls());
        imageGrid.setAdapter(imageAdapter);
    }

    public void modifyStar() {
        ImageButton star1 = findViewById(R.id.star_button_1);
        ImageButton star2 = findViewById(R.id.star_button_2);
        ImageButton star3 = findViewById(R.id.star_button_3);
        ImageButton star4 = findViewById(R.id.star_button_4);
        ImageButton star5 = findViewById(R.id.star_button_5);

        if(model.getLoaded() == true) {
            switch (model.getFilter()) {
                case 1:
                    star1.setBackgroundResource(R.drawable.star_filled_icon);
                    break;

                case 2:
                    star1.setBackgroundResource(R.drawable.star_filled_icon);
                    star2.setBackgroundResource(R.drawable.star_filled_icon);
                    break;

                case 3:
                    star1.setBackgroundResource(R.drawable.star_filled_icon);
                    star2.setBackgroundResource(R.drawable.star_filled_icon);
                    star3.setBackgroundResource(R.drawable.star_filled_icon);
                    break;

                case 4:
                    star1.setBackgroundResource(R.drawable.star_filled_icon);
                    star2.setBackgroundResource(R.drawable.star_filled_icon);
                    star3.setBackgroundResource(R.drawable.star_filled_icon);
                    star4.setBackgroundResource(R.drawable.star_filled_icon);
                    break;

                case 5:
                    star1.setBackgroundResource(R.drawable.star_filled_icon);
                    star2.setBackgroundResource(R.drawable.star_filled_icon);
                    star3.setBackgroundResource(R.drawable.star_filled_icon);
                    star4.setBackgroundResource(R.drawable.star_filled_icon);
                    star5.setBackgroundResource(R.drawable.star_filled_icon);
                    break;

                default:
                    star1.setBackgroundResource(R.drawable.star_empty_icon);
                    star2.setBackgroundResource(R.drawable.star_empty_icon);
                    star3.setBackgroundResource(R.drawable.star_empty_icon);
                    star4.setBackgroundResource(R.drawable.star_empty_icon);
                    star5.setBackgroundResource(R.drawable.star_empty_icon);
                    break;
            }
        }
    }
}