package com.example.martin.capturepicture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    ImageView picture;
    Button capture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        picture = (ImageView) findViewById(R.id.picture);
        capture = (Button) findViewById(R.id.capture);
        capture.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 0) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            picture.setImageBitmap(bitmap);
        }
    }
}
