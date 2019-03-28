package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    RectF rectF;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        int left = (getWidth() - bitmapWidth) / 2;
        int top = (getHeight() - bitmapHeight) / 2;

        rectF.left = left + bitmapWidth / 4f;
        rectF.top = top + bitmapHeight / 4f;
        rectF.right = left + (bitmapWidth * 3f / 4f);
        rectF.bottom = top + bitmapHeight * 3f / 4f;

        canvas.save();
        canvas.clipRect(rectF);
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.restore();
    }
}
