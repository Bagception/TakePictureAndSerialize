package de.philipphock.bagception.camerasubsystem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
                
    } 

    
    public void ontakePictureButtonClick(View v){
    	Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) { 
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            
        }

    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	Log.d("picture",requestCode+ " "+resultCode);
    	if (requestCode == REQUEST_IMAGE_CAPTURE){
    		Toast.makeText(this, "picture take", Toast.LENGTH_SHORT).show();
    		Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            
            //send as string (this would work over bluetooth)
            Intent i = new Intent(this,PictureSerializing.class);
            i.putExtra("img", PictureSerializer.serialize(imageBitmap));
            startActivity(i);
    	}else{
    		Toast.makeText(this, "picture not take", Toast.LENGTH_SHORT).show();
    	}
    }
    

     
}
