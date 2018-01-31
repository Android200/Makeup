package com.gdg.makeup.makeup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<grid_v> list = getList();

        final CustomAdapter adapter = new CustomAdapter(this, R.layout.grid_v, list);

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent myIntent = null;
                if (position == 0) {
                    myIntent = new Intent(MainActivity.this, Bridal_Makeup.class);

                }
                if (position == 1) {
                    myIntent = new Intent(MainActivity.this, Brother_Makeup.class);

                }
                if (position == 2) {
                    myIntent = new Intent(MainActivity.this, EverydayMakeup.class);

                }
                if (position == 3) {
                    myIntent = new Intent(MainActivity.this, PartyMakeup.class);
                }
                startActivity(myIntent);

            }
        });
    }

    public ArrayList<grid_v> getList() {
        ArrayList<grid_v> list = new ArrayList<grid_v>();
        list.add(new grid_v("Bridal Makeup", R.drawable.bridalicon));
        list.add(new grid_v("Carnival Makeup", R.drawable.carnivalicon));
        list.add(new grid_v("Everyday Makeup", R.drawable.everydayicon));
        list.add(new grid_v("Party Makeup", R.drawable.partyicon));
        return list;
    }

    class CustomAdapter extends ArrayAdapter<grid_v> {

        private LayoutInflater inflater;

        private int resource;

        public CustomAdapter(Context context, int resource, List<grid_v> data) {
            super(context, resource, data);
            inflater = LayoutInflater.from(context);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(resource, parent, false);
            }

            grid_v makeup = getItem(position);

            TextView tv = (TextView) convertView.findViewById(R.id.tv_test);
            tv.setText(makeup.name);

            ImageView iv = (ImageView) convertView.findViewById(R.id.iv_image);
            iv.setImageResource(makeup.drawableRes);

            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                // Code you want run when activity is clicked
                Intent mintent = new Intent(this, About.class);
                startActivity(mintent);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}