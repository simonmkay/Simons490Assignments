package com.simonkay.notmymusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simonkay.notmymusic.R;

/**
 * Created by Simon Kay on 11/2/2014.
 */
public class InPlaceFragment extends Fragment {

    public InPlaceFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }
}
