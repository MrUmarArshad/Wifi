package com.example.mruma.hackerapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


//      private StringBuilder sb = new StringBuilder();
//    List<ScanResult> scanList;
//    WifiManager wifi;
//    ListView lv;
//    int size = 0;
//    List<ScanResult> results;
//
//    String ITEM_KEY = "key";
//    ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();
//    SimpleAdapter adapter;
//    ImageButton setWifi;
    WifiManager wifiManager;
    WifiReceiver receiverWifi;
    List<ScanResult> wifiList;
    List<String> listOfProvider;

    ListView listViwProvider;
    TextView textStatus;
    ImageView iv;
    TextView textView;
    String str;


    String providerName;
    int wifisignle;

    List<Integer> wifiSignalLevel=new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        listOfProvider = new ArrayList<String>();


        listViwProvider = (ListView) findViewById(R.id.lv_result);

        /*setting the resources in class*/

//        setWifi = (ImageButton) findViewById(R.id.ib_scanresult);
        iv=(ImageView)findViewById(R.id.iv_single);
        textStatus=(TextView)findViewById(R.id.tv_status);
        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        if (wifiManager.isWifiEnabled() == false) {
            Toast.makeText(MainActivity.this, "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
                    wifiManager.setWifiEnabled(true);
            scaning();
        }
        else { wifiManager.setWifiEnabled(true);
            scaning();

        }

        listViwProvider.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ?> parent, View view,
                                    int position, long id) {
                str = '"' + wifiList.get(position).SSID.toString() + '"';

                Intent i =new Intent(MainActivity.this,ShowDetail.class);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                i.putExtra("Wifi", str);



                startActivity(i);
//                i.putExtra("Detail","Processing " +providerName +"..."+'\n'+"Starting bash shell ..."+'\n'+" Getting network " + providerName + " packets "+ '\n' + "Resolving network " +providerName + " packets" + '\n' +"Analyzing..."+'\n'+"Get info of divices"+ "Get Wifi channel" + '\n' + "Send Authorization code"+ '\n' + "Authorization Successful" + '\n' + "Sends a connection request to  " + providerName +'\n'+" The " + providerName + " connection is successful"+ "Analyzing..." +'\n'+ "Data Processing" + '\n'+"Congratulation to decipher  password\n" + "success.").toString();


//                ImportDialog action = new ImportDialog(MainActivity.this, (wifiList.get(position)).toString());
//                action.showDialog();
                Toast.makeText(getApplicationContext(),wifiList.get(position).SSID,Toast.LENGTH_LONG).show();

                
                //ImageView IMAG= (ImageView) view.findViewById(R.id.iv_single);
                //IMAG.setImageResource(R);

            }
        });







//        lv = (ListView)findViewById(R.id.lv_result);
//
//        ImageButton imageButton=(ImageButton)findViewById(R.id.ib_scanresult);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//                wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//
//                if (wifi.isWifiEnabled() == false)
//                {
//                    Toast.makeText(MainActivity.this, "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
//                    wifi.setWifiEnabled(true);
//                }
//
//                arraylist.clear();
//                wifi.startScan();
//
//
//                Toast.makeText(MainActivity.this, "Scanning...." + size, Toast.LENGTH_SHORT).show();
//
//                try
//                {
//                    size = size - 1;
//                    while (size >= 0)
//                    {
//                        HashMap<String, String> item = new HashMap<String, String>();
//                        item.put(ITEM_KEY, results.get(size).SSID + "  " + results.get(size).capabilities);
//                        arraylist.add(item);
//                        size--;
//                        adapter.notifyDataSetChanged();
//
//                    }
//
//                }
//
//                catch (Exception e)
//                { }
//
//            }
//
//        });
//
//            registerReceiver(new BroadcastReceiver()
//        {
//            @Override
//            public void onReceive(Context c, Intent intent)
//            {
//                results = wifi.getScanResults();
//                size = results.size();
//            }
//        }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));





    FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new Home_Fragment()).commit();
    }



//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "image button", Toast.LENGTH_SHORT).show();
//                adapter = new SimpleAdapter(MainActivity.this, arraylist, R.layout.single_row, new String[] { ITEM_KEY }, new int[] { R.id.tv_wifi_name,R.id.tv_status,R.id.iv_single });
//                lv.setAdapter(adapter);
//                wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//                if (wifi.isWifiEnabled() == false)
//                {
//                    Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
//                    wifi.setWifiEnabled(true);
//                }
//               getWifiNetworksList();
//
//
//
//            }
//        });










    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fm = getSupportFragmentManager();

        if (id == R.id.nav_Home) {
            Toast.makeText(this, "home button", Toast.LENGTH_SHORT).show();

            fm.beginTransaction().replace(R.id.content_frame,new Home_Fragment()).commit();
        }
        else if (id == R.id.nav_WifiAccess) {

            Toast.makeText(this, "Wifi Setting", Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.content_frame, new WifiAccess_Fragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    private void scaning() {

        receiverWifi = new WifiReceiver();

        registerReceiver(receiverWifi, new IntentFilter(
                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();

    }
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiverWifi);
    }

    protected void onResume() {
        registerReceiver(receiverWifi, new IntentFilter(
                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }

    class WifiReceiver extends BroadcastReceiver {

        // This method call when number of wifi connections changed
        public void onReceive(Context c, Intent intent) {
            wifiList = wifiManager.getScanResults();
            Collections.sort(wifiList, new Comparator<ScanResult>() {
                @Override
                public int compare(ScanResult lhs, ScanResult rhs) {
                    return (lhs.level > rhs.level ? -1 : (lhs.level == rhs.level ? 0 : 1));
                }
            });
            listOfProvider.clear();
            int maxLevel = 5;


            for (int i = 0; i < wifiList.size(); i++) {

                providerName = (wifiList.get(i).SSID).toString();
//                        +"\n"+(wifiList.get(i).level)
                listOfProvider.add(providerName);

                wifisignle =wifiList.get(i).level;
                wifiSignalLevel.add(wifisignle);
            }
                com.example.mruma.hackerapp.ListAdapter adapter = new com.example.mruma.hackerapp.ListAdapter(MainActivity.this,                    listOfProvider,wifiSignalLevel);
                listViwProvider.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

//            int state = wifiManager.getWifiState();
//            if(state == WifiManager.WIFI_STATE_ENABLED) {
//
//
//
//                for (ScanResult result : wifiList) {
//                    if(result.BSSID.equals(wifiManager.getConnectionInfo().getBSSID())) {
//                        int level = WifiManager.calculateSignalLevel(wifiManager.getConnectionInfo().getRssi(), result.level);
//                        int difference = level * 100 / result.level;
//                        int signalStrangth= 0;
//                        if(difference >= 100)
//                            signalStrangth=(R.drawable.wifisingle4);
//                        else if(difference >= 75)
//                            signalStrangth = (R.drawable.wifisingle3);
//                        else if(difference >= 50)
//                            signalStrangth = (R.drawable.wifisingle2);
//                        else if(difference >= 25)
//                            signalStrangth = (R.drawable.wifisingle1);
//
//
//                       i.setText(tv.getText() + "\nDifference :" + difference + " signal state:" + signalStrangth);
//                        textStatus.setText(textStatus.getText() + "\nDifference :" + difference + " signal state:" + signalStrangth);
//
//                    }
//
//                }
//            }

        }

//    private void getWifiNetworksList(){
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
//        final WifiManager wifiManager =
//                (WifiManager)getSystemService(Context.WIFI_SERVICE);;
//        registerReceiver(new BroadcastReceiver(){
//            public void onReceive(Context context, Intent intent) {
//                sb = new StringBuilder();
//                scanList = wifiManager.getScanResults();
//                sb.append("\n  Number Of Wifi connections :" + " " +scanList.size()+"\n\n");
//                for(int i = 0; i < scanList.size(); i++){
//                    sb.append(new Integer(i+1).toString() + ". ");
//                    sb.append((scanList.get(i)).toString());
//                    sb.append("\n\n");
//                }
//
//                lv.setAdapter(adapter);
//            }
//
//        },filter);
//        wifiManager.startScan();
//    }



    }

