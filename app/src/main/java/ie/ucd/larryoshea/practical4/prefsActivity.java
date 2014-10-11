package ie.ucd.larryoshea.practical4;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by larryoshea on 07/10/2014.
 */
public class prefsActivity extends PreferenceActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Preferences");
        addPreferencesFromResource(R.xml.myapppreferences);
    }
}
