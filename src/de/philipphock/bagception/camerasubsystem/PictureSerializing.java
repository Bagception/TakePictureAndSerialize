package de.philipphock.bagception.camerasubsystem;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureSerializing extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_serializing);
		String imgdata= getIntent().getExtras().getString("img");
		Bitmap bmp=PictureSerializer.deserialize(imgdata);
		
		ImageView mImageView = (ImageView) findViewById(R.id.imageView1);
        mImageView.setImageBitmap(bmp);
		
	}


}
