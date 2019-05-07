// Parts of code may be taken from the class examples

package a4.a4;

import java.util.Observable;
import java.util.Vector;
import android.widget.GridView;

public class Model extends Observable {

    private static final Model ourInstance = new Model();

    static Model getInstance()
    {
        return ourInstance;
    }

    private String fullImgUrl;
    private int filter = 0;
    private boolean loaded = false;
    private GridView imageGrid;

    private String imageUrls[] = {
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/bunny.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/chinchilla.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/doggo.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/fox.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/hamster.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/husky.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/kitten.png",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/loris.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/puppy.jpg",
            "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/sleepy.png"};

    private float rating[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private Vector<String> myUrls = new Vector<>();
    private Vector<Float> myRatings = new Vector<>();


    public void setFullImageUrl(String url) {
        fullImgUrl = url;
    }

    public String getFullImgUrl() {
        return fullImgUrl;
    }

    public void setFilter(int num) {
        filter = num;
    }

    public int getFilter() {
        return filter;
    }

    public void setBarRating(int pos, float rate) {
        for(int i=0; i<imageUrls.length; i++) {
            if(imageUrls[i] == myUrls.get(pos)) {
                rating[i] = rate;
            }
        }
    }

    public void setDefaultRating() {
        for(int i=0; i<rating.length; i++) {
            rating[i] = 0;
        }
    }

    public void setLoaded(boolean b) {
        loaded = b;
    }

    public boolean getLoaded() {
        return loaded;
    }

    public Vector<String> getMyUrls() {
        return myUrls;
    }

    public Vector<Float> getMyRatings() {
        return myRatings;
    }

    public void clearVectors() {
            myUrls.clear();
            myRatings.clear();
    }

    public void setMyVectors(float num){
        clearVectors();
        for(int i=0; i<imageUrls.length; i++) {
            if(rating[i] >= num) {
                myUrls.add(imageUrls[i]);
                myRatings.add(rating[i]);
            }
        }
    }

    public void setOriginal() {
        clearVectors();
        for(int i=0; i<imageUrls.length; i++) {
            myUrls.add(imageUrls[i]);
            myRatings.add(rating[i]);
        }
    }

    public void setGrid(GridView ig) {
        imageGrid = ig;
    }

    public GridView getGrid() {
        return imageGrid;
    }
}
