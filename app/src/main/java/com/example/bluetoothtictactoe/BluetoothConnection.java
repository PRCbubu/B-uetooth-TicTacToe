package com.example.bluetoothtictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class BluetoothConnection extends AppCompatActivity
{
    TextView SearchText = (TextView) findViewById(R.id.Searchtext);

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED)
            {
                return;
            }
            bluetoothAdapter.startDiscovery();
        }
    }

    private void searchForDevices(View view)
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_connection);

        Button ConnectionDevices = (Button) findViewById(R.id.ConnectDevices);
        Button StartPlayerButton = (Button) findViewById(R.id.StartPlayerButton);
        ListView ListOfDevices = (ListView) findViewById(R.id.ListOfDevices);
        EditText Player2 = (EditText) findViewById(R.id.InputName2);


        Bundle info = getIntent().getExtras();
        String Player1 = info.getString("NameSet1");

        ConnectionDevices.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Player2.setVisibility(View.VISIBLE);
                SearchText.setVisibility(View.VISIBLE);
                SearchText.setText("Searching....");
                SearchText.setEnabled(false);
                ListOfDevices.setVisibility(View.VISIBLE);
                searchForDevices(view);
            }
        });
    }


}