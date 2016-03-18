package development.alberto.com.multiscreenfragments.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import development.alberto.com.multiscreenfragments.R;

/**
 * Created by alber on 18/03/2016.
 */
public class DetailFragment extends Fragment {

    private TextView detailsText;
    private String url;
    public DetailFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);
        detailsText = (TextView) v.findViewById(R.id.detailsText);
        detailsText.setText(getURL());
        return v;
    }


    public void setText(String url) {
//mobile reference
        if(this.url ==null) { //we are in a mobile mode...because the fragment needs to be called and recreated and initially the url is null until we send it to the view...
            this.url = url;
        } else {
//tablet reference
            TextView detailsText = (TextView) getActivity().findViewById(R.id.detailsText);//in case the fragment is static in tablet mode, the class wont get recreated...
            detailsText.setText(url);
        }
    }
    public String getURL(){
        return this.url;
    }

}
