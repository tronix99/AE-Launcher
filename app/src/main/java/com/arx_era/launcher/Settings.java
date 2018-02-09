package com.arx_era.launcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Created by tronix99 on 6/2/18.
 */
public class Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);// Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.settings);
            SharedPreferences pref = getActivity().getSharedPreferences(
                    "Pref",
                    Context.MODE_PRIVATE);

            final SharedPreferences.Editor editor = pref.edit();

            EditTextPreference username = (EditTextPreference) getPreferenceManager().findPreference("username");
            username.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    editor.putString("username", newValue.toString());
                    editor.commit();
                    return false;
                }
            });
        }
    }

}