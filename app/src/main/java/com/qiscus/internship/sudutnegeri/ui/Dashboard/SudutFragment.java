package com.qiscus.internship.sudutnegeri.ui.Dashboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qiscus.internship.sudutnegeri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SudutFragment extends Fragment {


    public SudutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sudut, container, false);
    }

    public static Fragment newInstance() {
        return new SudutFragment();
    }
}
