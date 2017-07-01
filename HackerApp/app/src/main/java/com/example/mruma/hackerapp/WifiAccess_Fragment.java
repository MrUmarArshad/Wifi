package com.example.mruma.hackerapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WifiAccess_Fragment extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_wifi_access_, container, false);




        return view1;
    }

    @Nullable
//    @Override
//    public View getView( int position, View convertView, ViewGroup parent) {
//        View view = inflater.inflate(R.layout.single_row, parent, false);
//        TextView SSID  = (TextView) view.findViewById(R.id.tv_wifi_name);
//        TextView BSSID = (TextView) view.findViewById(R.id.tv_status);
//        ImageView iv = (ImageView) view.findViewById(R.id.iv_single);
//        SSID.setText(my_array.get(position));
//        BSSID.setText(wifiScanList.get(position).BSSID);
//        int current_level = 5;
//        int signal_level = WifiManager.calculateSignalLevel(WifiManager.getConnectionInfo().getRssi(), current_level);
//        int signal_difference = (signal_level * 100) / current_level;
//
//        int wifiSignalLevel = wifi_level.get(my_array.get(position));
//
//        Log.d(my_array.get(position) + " Strength ",
//                String.valueOf(wifiSignalLevel));
//
//        if (wifiSignalLevel >= -70) {
//            iv.setImageResource(R.drawable.wifisingle4);
//        } else if (wifiSignalLevel >= -80) {
//            iv.setImageResource(R.drawable.wifisingle3);
//        } else if (wifiSignalLevel >= -90) {
//            iv.setImageResource(R.drawable.wifisingle2);
//        } else if (wifiSignalLevel >= -100) {
//            iv.setImageResource(R.drawable.wifisingle1);
//        }
//
//
//
//
//        return super.getView();
//    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);









    }
//    protected void onPause() {
//        getActivity().unregisterReceiver(wifiReciever);
//        super.onPause();
//    }
//
//    protected void onResume() {
//        getActivity().registerReceiver(wifiReciever, new IntentFilter(
//                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//        super.onResume();
//    }
//
//    class WifiScanReceiver extends BroadcastReceiver {
//        @SuppressLint("UseValueOf")
//        public void onReceive(Context c, Intent intent) {
//            wifiScanList = mainWifiObj.getScanResults();
//            for (int i = 0; i < wifiScanList.size(); i++) {
//                my_array.add((wifiScanList.get(i)).SSID);
//            }
//            myAdapter.notifyDataSetChanged();
//        }
//    }
}
