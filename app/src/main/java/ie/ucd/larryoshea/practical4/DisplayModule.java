package ie.ucd.larryoshea.practical4;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by larryoshea on 02/10/2014.
 */
public class DisplayModule extends Activity {
    String tag = "LOS-DISPLAY";

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get preferences for the background colour - at the bottom we will use this to set the colour
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String colourSetting = sharedPref.getString("pref_colourType", "default colour");
        Log.d(tag,colourSetting);

        setTitle("Module Information");
        String topic_info = getIntent().getStringExtra("Module_Info");
        /*
        Parse module info which looks like this - using | seperator
        COMP47330|COMP47330 Practical Android Programming|10|Module to teach development of android Apps
         */
        String[] topic_array = topic_info.split("\\|");
        for (String element : topic_array) {
            // for debugging
            Log.d(tag,element);
        }

        // create linear layout - not using XML layout here
        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);

        if (topic_array.length == 4) {
            // add text view to linear layout
            // first textview is Module name
            TextView tv=new TextView(getApplicationContext());
            tv.setText("Module: " + topic_array[1]);
            layout.addView(tv);

            // seconds textview is module credits
            TextView tv2=new TextView(getApplicationContext());
            tv2.setText("Credits: " + topic_array[2]);
            layout.addView(tv2);

            // third textview is module description
            TextView tv3=new TextView(getApplicationContext());
            tv3.setText("Description: " + topic_array[3]);
            layout.addView(tv3);

            // setting the background colour based on preferences setting
            if (colourSetting.equals("Red is selected")) {
                layout.setBackgroundColor(Color.RED);
            } else if (colourSetting.equals("Green is selected")) {
                layout.setBackgroundColor(Color.GREEN);
            } else if (colourSetting.equals("Magenta is selected")) {
                layout.setBackgroundColor(Color.MAGENTA);
            }
        }
    }

}
