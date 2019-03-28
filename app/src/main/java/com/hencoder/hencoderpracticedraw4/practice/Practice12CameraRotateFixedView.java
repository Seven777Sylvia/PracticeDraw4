package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    private int bitmapHeight;
    private int bitmapWidth;
    private Point centerPoint1;
    private Point centerPoint2;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        bitmapHeight = bitmap.getHeight();
        bitmapWidth = bitmap.getWidth();

        centerPoint1 = new Point(point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
        centerPoint2 = new Point(point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        camera.save();
        matrix.reset();
        camera.rotateX(30f);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerPoint1.x, -centerPoint1.y);
        matrix.postTranslate(centerPoint1.x, centerPoint1.y);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        camera.save();
        matrix.reset();
        camera.rotateY(30f);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerPoint2.x, -centerPoint2.y);
        matrix.postTranslate(centerPoint2.x, centerPoint2.y);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
