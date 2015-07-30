package com.nanicole.mywebber.Util;

import com.nanicole.mywebber.MyInterface.Pic_Download_interface;
import com.nanicole.mywebber.network.Pic_Download;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import android.widget.TextView;

public class BitmapUtil {
	public static Bitmap SquareBitmap(Bitmap bmp){
		Bitmap b;
		int h=bmp.getHeight();
		int w=bmp.getWidth();
		int length=(h>=w)?w:h;
		if(h>=w){
			b=Bitmap.createBitmap(bmp, 0, (bmp.getHeight()-length)/2, length, length);
		}
		else{
			b=Bitmap.createBitmap(bmp, (bmp.getWidth()-length)/2, 0, length, length);
		}

		return b;

	}
	public static Bitmap RoundBitmap(Bitmap bmp){
		Bitmap b=SquareBitmap(bmp);
		int length=b.getHeight();
		Bitmap cover=Bitmap.createBitmap(length, length, Config.ARGB_8888);

		Canvas c=new Canvas(cover);
		Paint p=new Paint();
		p.setAntiAlias(true);

		Rect rect=new Rect(0, 0, length, length);
		RectF rectf=new RectF(rect);
		c.drawARGB(0, 0, 0, 0);
		c.drawRoundRect(rectf, length/2, length/2, p);
		p.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		c.drawBitmap(b, rect, rect, p);
		return cover;

	}
	public static Bitmap Check_Bitmap(Bitmap bmp){
		int stable=2000;
		int h=bmp.getHeight();
		int w=bmp.getWidth();
		if(h<2000&&w<2000) return bmp;
		Matrix m=new Matrix();
		m.postScale(0.5f, 0.5f);
		
		bmp=Bitmap.createBitmap(bmp, 0, 0, w, h, m, true);
		return bmp;
	}
	

}
