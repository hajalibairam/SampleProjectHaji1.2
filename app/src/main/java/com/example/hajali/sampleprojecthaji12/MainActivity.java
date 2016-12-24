package com.example.hajali.sampleprojecthaji12;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap myBitmap;
    Bitmap tempBitmap;
    Canvas tempCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_view);
        myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.john_travolta);
        tempBitmap = Bitmap.createBitmap(myBitmap.getWidth(), myBitmap.getHeight(), Bitmap.Config.RGB_565);
        tempCanvas = new Canvas(tempBitmap);
        tempCanvas.drawBitmap(myBitmap, 0, 0, null);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


//                Bitmap.createBitmap(myBitmap.getWidth(), myBitmap.getHeight(), Bitmap.Config.RGB_565);
//                tempBitmap = Bitmap.createBitmap(getD)

                setUpImage((int) event.getX(), (int) event.getY());

                Log.e("Location X", String.valueOf(event.getX()));
                Log.e("Location Y", String.valueOf(event.getY()));
                return true;
            }
        });


    }

    public void setUpImage(int x, int y) {
        Paint myPaint = new Paint();
        myPaint.setColor(Color.BLACK);

        tempCanvas = new Canvas(tempBitmap);


        tempCanvas.drawBitmap(tempBitmap, 0, 0, null);

        imageView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));

        tempCanvas.drawCircle(x, y, 10, myPaint);
        imageView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));

    }
}
