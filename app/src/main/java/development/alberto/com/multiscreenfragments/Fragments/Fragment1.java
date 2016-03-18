package development.alberto.com.multiscreenfragments.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import development.alberto.com.multiscreenfragments.OnItemSelectedListener;
import development.alberto.com.multiscreenfragments.R;

/**
 * Created by alber on 18/03/2016.
 */
public class Fragment1 extends Fragment {

    private  Button button;

    private OnItemSelectedListener listener;

    public Fragment1() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);

        button = (Button) v.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateDetail("Time: ");
            }
        });
        
        return v;
    }

    private void updateDetail(String fake) {

        // create fake data
        String newTime = String.valueOf(System.currentTimeMillis());
        // send data to activity
        listener.onRssItemSelected( fake + newTime);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement MyListFragment.OnItemSelectedListener");
        }
    }



}
