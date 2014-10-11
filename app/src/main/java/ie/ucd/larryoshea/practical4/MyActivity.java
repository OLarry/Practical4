package ie.ucd.larryoshea.practical4;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    String Tag = "LOS-PRACTICAL4";
    String[] module_full; // array containing strings of UCD module info with | seperator
    String[] module_summary;
    Boolean useXmlLayout = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        // get full module info from strings.xml
        module_full = res.getStringArray(R.array.ucd_module_full);
        for (String mod_info: module_full) {
            Log.d(Tag, mod_info);
        }

        // set view according to xml
        setContentView(R.layout.activity_my);

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        // on click start new activity and send intent to new activity with full module info
        Intent i = new Intent("ie.ucd.larryoshea.practical4.DisplayModule");
        i.putExtra("Module_Info", module_full[position]);
        startActivity(i);
    }

    public void clickPrefs (View view) {
        Intent i = new Intent("ie.ucd.larryoshea.practical4.prefsActivity");
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // prompt to select colour from the menu also
            // start the preferences activity from settings
            Intent i = new Intent("ie.ucd.larryoshea.practical4.prefsActivity");
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}