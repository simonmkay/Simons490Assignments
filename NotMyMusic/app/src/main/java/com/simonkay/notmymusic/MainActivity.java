package com.simonkay.notmymusic;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getActionbar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Tab 1");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("Tab 2");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab2);

        ActionBar.Tab tab3 = actionbar.newTab().setText("Tab 3");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   private void add() {
   Toast toast = Toast.makeText(this, "adding", Toast.LENGTH_SHORT);
       toast.show();
   }

   private void search() {
        Toast toast = Toast.makeText(this, "Search", Toast.LENGTH_SHORT);
        toast.show();
        }


   private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }
}
