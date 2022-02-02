package com.example.siaip;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ListView listView;
    ArrayList<String> arrayList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Fragment1() {
    }

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1, container, false);
        listView = v.findViewById(R.id.listview);
        arrayList = getArguments().getStringArrayList("message");

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = arrayAdapter.getItem(position);
                Bundle aaa = new Bundle();
                aaa.putString("aaa", value);
                Fragment2 fragInfo1 = new Fragment2();
                fragInfo1.setArguments(aaa);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.framelayout, fragInfo1, null)
                        .addToBackStack(null).commit();
            }
        });
        return v;
    }
}