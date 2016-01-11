package com.example.admin.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class myDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);


        Intent intent=getIntent();
        if (intent!=null)
        {
            int flowerid=intent.getIntExtra("flowerName",R.drawable.image1);
            String flower_name=intent.getStringExtra("flowerName");
            ImageView myImage= (ImageView) findViewById(R.id.mydialogImage);
            myImage.setImageResource(flowerid);
            TextView myText= (TextView) findViewById(R.id.mydialogName);
            myText.setText("This Flower is "+flower_name);
        }
    }

    public void close(View v)
    {
        finish();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
