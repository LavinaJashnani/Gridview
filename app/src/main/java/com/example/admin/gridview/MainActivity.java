package com.example.admin.gridview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {


    GridView mygrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mygrid=(GridView) findViewById(R.id.gridView);
        mygrid.setAdapter(new VizAdapter(this));
        mygrid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id)
    {
        Intent intent=new Intent(this,myDialog.class);
       // viewholder holder  = (viewholder)view.getTag();
        //flowerarray temp= (flowerarray) holder.myFlower.getTag();
//        intent.putExtra("flowerImage",temp.flowerId);
       // intent.putExtra("flowerName",temp.flower_name);
        startActivity(intent);

    }



    class flowerarray
    {
        int flowerId;
        String flower_name;

        flowerarray(int flowerId,String flower_name)
        {
            this.flowerId=flowerId;
            this.flower_name=flower_name;
        }
    }


    class viewholder
    {
        ImageView myFlower;
        viewholder(View v)
        {
            myFlower=(ImageView) v.findViewById(R.id.imageView);
        }
    }
// this base adapter provied the rough idea what an adapter shud do
    // its vil gv an error press alt+enter and implement the methods


    class VizAdapter extends BaseAdapter
    {
        int i;
        Context context;
        ArrayList<flowerarray> list;

        VizAdapter (Context context)
        {
            list=new ArrayList<flowerarray>();

            this.context=context;

            Resources res=context.getResources();
            String[] tempFlowerName=res.getStringArray(R.array.flower);
            int[] flowerImages= {R.drawable.image1,R.drawable.image3,R.drawable.image4,R.drawable.image6,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8};

            for (i=0;i<8;i++)
            {
                flowerarray tempFlower=new flowerarray(flowerImages[i],tempFlowerName[i]);
                list.add(tempFlower);
            }
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {

            View row=view;
            viewholder holder=null;
            if(view==null)
            {
                LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row=inflater.inflate(R.layout.single_items,viewGroup,false);
                holder=new viewholder(row);
                row.setTag(holder);
            }

            else
            {
                holder=(viewholder) row.getTag();
            }

            flowerarray temp=list.get(i);
            holder.myFlower.setImageResource(temp.flowerId);
            return row;

        }


    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
