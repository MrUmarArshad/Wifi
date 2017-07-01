package com.example.mruma.hackerapp;


import android.app.Activity;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {
    Activity mActivity;
    List<String> wifiName;
    List<ScanResult> wifiList;


    List <Integer> ghb;


    private LayoutInflater inflater;

    public ListAdapter(Activity a, List<String> wifiName,List<Integer> wifiSignalLevel) {
        super(a, R.layout.single_row, wifiName);
        mActivity = a;
        inflater = LayoutInflater.from(mActivity);
        this.wifiName = wifiName;
        this.ghb=wifiSignalLevel;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.single_row, parent, false);
        TextView wifiProvider = (TextView) convertView.findViewById(R.id.tv_wifi_name);

        wifiProvider.setText(wifiName.get(position));


        ImageView iv =(ImageView)convertView.findViewById(R.id.iv_single);
        int wifisignle=ghb.get(position);


        if (wifisignle >= -70) {
            iv.setImageResource(R.drawable.wifi_0);
        } else if (wifisignle >= -80) {
            iv.setImageResource(R.drawable.wifi_3);
        } else if (wifisignle >= -90) {
            iv.setImageResource(R.drawable.wifi_2);
        } else if (wifisignle >= -100) {
            iv.setImageResource(R.drawable.wifi_1);
        }










//           int wifiSignalLevel =wifiList.get(listOfProvider.get(position));
//               Log.d(listOfProvider.get(position) + " Strength ", String.valueOf(wifiSignalLevel));
//                int current_level = 5;
//                int signal_level = WifiManager.calculateSignalLevel(wifiManager
//                        .getConnectionInfo().getRssi(), current_level);
//                int signal_level = (signal_level * 100) / current_level;
//
//                Log.d("Signal_level", String.valueOf(signal_level));
//                if (wifiSignalLevel >= -70) {
//                    iv.setImageResource(R.drawable.wifisingle1);
//                } else if (wifiSignalLevel >= -80) {
//                    iv.setImageResource(R.drawable.wifisingle2);
//                } else if (wifiSignalLevel >= -90) {
//                    iv.setImageResource(R.drawable.wifisingle3);
//                } else if (wifiSignalLevel >= -100) {
//                    iv.setImageResource(R.drawable.wifisingle4);
//                }

        return convertView;
    }

}