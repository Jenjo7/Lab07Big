package com.example.giannisavini.lab07big;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;

import com.example.giannisavini.lab07big.database.ContactDbManager;

/**
 * Created by gianni.savini on 20/04/2017.
 */
public class ListFragment extends Fragment {

    public interface ListListener {
        void onClickAddContact();
    }

    private ListListener listener;

    public ListFragment() {

    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    private ArrayAdapter<Contact> adapter;
    private ContactDbManager dbManager;
    private Toolbar toolbar;
}
