package com.willblaschko.android.alexavoicelibrary;

import android.Manifest;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.vise.baseble.model.BluetoothLeDevice;
import com.vise.baseble.utils.BleUtil;
import com.willblaschko.android.alexavoicelibrary.Service.BLEService;
import com.willblaschko.android.alexavoicelibrary.adapter.DeviceAdapter;

import java.util.ArrayList;
import java.util.List;

public class BLEConnect2Activity extends AppCompatActivity {

    private static final String TAG = "BLEConnect2Activity";

    private BLEService.BLEBinder bleBinder;

    private KProgressHUD kProgressHUD;

    private ListView listView;
    //设备扫描结果展示适配器
    private DeviceAdapter adapter;
    //设备扫描结果集合
    private volatile List<BluetoothLeDevice> bluetoothLeDeviceList = new ArrayList<>();

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bleBinder = (BLEService.BLEBinder) iBinder;
            checkBluetoothPermission();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private ScanReceiver scanReceiver;
    private ConnectingReceiver connectingReceiver;
    private ConnectedReceiver connectedReceiver;
    private ConnectFailReceiver connectFailReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleconnect2);

        Log.d(TAG, "onCreate: " + isServiceWork(this,"com.willblaschko.android.alexavoicelibrary.Service.BLEService"));
        if (!isServiceWork(this,"com.willblaschko.android.alexavoicelibrary.Service.BLEService")) {
            bindService();
        }

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        getSupportActionBar().setTitle("蓝牙连接");

        listView = (ListView) findViewById(R.id.list);
        adapter = new DeviceAdapter(this);
        listView.setAdapter(adapter);

        Log.e(TAG, "onCreate: " + bleBinder);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BluetoothLeDevice device = (BluetoothLeDevice) adapter.getItem(i);
                bleBinder.connectBLE(device.getAddress());
            }
        });

        connectedReceiver = new ConnectedReceiver();
        connectingReceiver = new ConnectingReceiver();
        connectFailReceiver = new ConnectFailReceiver();
        scanReceiver = new ScanReceiver();
        registerReceiver("com.example.broadcasttest.CONNECTED",connectedReceiver);
        registerReceiver("com.example.broadcasttest.CONNECTING",connectingReceiver);
        registerReceiver("com.example.broadcasttest.DEVICE_FOUND",scanReceiver);
        registerReceiver("com.example.broadcasttest.CONNECT_FAILURE",connectFailReceiver);
    }

    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName
     *            是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
    public boolean isServiceWork(Context mContext, String serviceName) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(40);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }

    private void registerReceiver(String action,BroadcastReceiver receiver) {
        intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        localBroadcastManager.registerReceiver(receiver,intentFilter);
    }

    private void bindService() {
        Log.d(TAG, "bindService: ");
        Intent startIntent = new Intent(this,BLEService.class);
        startService(startIntent);
        Intent bindIntent = new Intent(this,BLEService.class);
        bindService(bindIntent,connection,BIND_AUTO_CREATE);
    }

    class ScanReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            bluetoothLeDeviceList = bleBinder.getBluetoothLeDeviceList();
            adapter.setDeviceList(bluetoothLeDeviceList);
        }
    }

    class ConnectingReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            kProgressHUD = new KProgressHUD(BLEConnect2Activity.this);
            kProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setDetailsLabel("正在连接")
                    .setAnimationSpeed(2)
                    .show();
        }
    }

    class ConnectedReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            kProgressHUD.dismiss();
//            getSupportActionBar().setIcon(R.drawable.home_disconnected_pressed);
            finish();
        }
    }

    class ConnectFailReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            kProgressHUD.dismiss();
            checkBluetoothPermission();
        }
    }

    /**
     * 检查蓝牙权限
     */
    private void checkBluetoothPermission() {
//        if (bluetoothLeDeviceStore != null) {
//            bluetoothLeDeviceStore.clear();
//        }
//        if (adapter != null && bluetoothLeDeviceList != null) {
//            bluetoothLeDeviceList.clear();
//            adapter.setDeviceList(bluetoothLeDeviceList);
//        }

        if (BleUtil.isBleEnable(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //校验是否已具有模糊定位权限
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                            100);
                } else {
                    //具有权限
                    bleBinder.startScan();
                }
            } else {
                Log.e(TAG, "checkBluetoothPermission: " + bleBinder);
                //系统不高于6.0直接执行
                bleBinder.startScan();
            }
        } else{
            BleUtil.enableBluetooth(this,1);
        }
    }

    /**
     * 打开或关闭蓝牙后的回调
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                checkBluetoothPermission();
            }
        } else if (resultCode == RESULT_CANCELED) {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 对返回的值进行处理，相当于StartActivityForResult
     */
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        doNext(requestCode, grantResults);
    }


    /**
     * 权限申请的下一步处理
     * @param requestCode 申请码
     * @param grantResults 申请结果
     */
    private void doNext(int requestCode, int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //同意权限
                checkBluetoothPermission();
            } else {
                // 权限拒绝，提示用户开启权限
                denyPermission();
            }
        }
    }

    /**
     * 权限申请被拒绝的处理方式
     */
    private void denyPermission() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(scanReceiver);
        localBroadcastManager.unregisterReceiver(connectedReceiver);
        localBroadcastManager.unregisterReceiver(connectingReceiver);
        localBroadcastManager.unregisterReceiver(connectFailReceiver);
    }
}
