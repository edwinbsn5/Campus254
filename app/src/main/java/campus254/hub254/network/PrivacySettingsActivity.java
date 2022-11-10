package campus254.hub254.network;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import campus254.hub254.network.common.ActivityBase;


public class PrivacySettingsActivity extends ActivityBase {

    Toolbar mToolbar;

    PreferenceFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_settings);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState != null) {

            fragment = (PreferenceFragment) getFragmentManager().getFragment(savedInstanceState, "currentFragment");

        } else {

            fragment = new PrivacySettingsFragment();
        }

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.settings_content, fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        getFragmentManager().putFragment(outState, "currentFragment", fragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.\

        switch (item.getItemId()) {

            case android.R.id.home: {

                finish();
                return true;
            }

            default: {

                return super.onOptionsItemSelected(item);
            }
        }
    }
}
