package development.alberto.com.multiscreenfragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import development.alberto.com.multiscreenfragments.Fragments.DetailFragment;
import development.alberto.com.multiscreenfragments.Fragments.Fragment1;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends FragmentActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);//activity main of any size by default..mobile or tablet..
        if(findViewById(R.id.container)!=null) { //we are in a mobile mode...
            Fragment1 fragment1 = new Fragment1();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        } // we are in a tablet...

    }

    @Override
    public void onRssItemSelected(String link) { //interface implementation, it is called by the button in fragment1 and send the data to the fragment 2 by the main...
        DetailFragment fragment2;
        if(findViewById(R.id.container)!=null) { //we are in a mobile mode...
             fragment2 = new DetailFragment();
             getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();

        } else { // we are in a tablet...
//             fragment2 = new DetailFragment();
             fragment2 = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
//            getSupportFragmentManager().beginTransaction().add(R.id.detail_fragment, fragment2).commit();
        }
        fragment2.setText(link);
    }
}
