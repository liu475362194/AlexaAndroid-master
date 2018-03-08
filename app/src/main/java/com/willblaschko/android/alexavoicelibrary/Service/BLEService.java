package com.willblaschko.android.alexavoicelibrary.Service;

import android.app.Service;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;


import com.vise.baseble.ViseBle;
import com.vise.baseble.callback.IBleCallback;
import com.vise.baseble.callback.IConnectCallback;
import com.vise.baseble.callback.scan.IScanCallback;
import com.vise.baseble.callback.scan.ScanCallback;
import com.vise.baseble.common.PropertyType;
import com.vise.baseble.core.BluetoothGattChannel;
import com.vise.baseble.core.DeviceMirror;
import com.vise.baseble.exception.BleException;
import com.vise.baseble.model.BluetoothLeDevice;
import com.vise.baseble.model.BluetoothLeDeviceStore;
import com.vise.baseble.utils.HexUtil;
import com.willblaschko.android.alexavoicelibrary.adapter.DeviceAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class BLEService extends Service {

    //设备扫描结果存储仓库
    private BluetoothLeDeviceStore bluetoothLeDeviceStore;
    //设备扫描结果集合
    private volatile List<BluetoothLeDevice> bluetoothLeDeviceList = new ArrayList<>();
    //设备扫描结果展示适配器
    private DeviceAdapter adapter;

    private ScanCallback scanCallback;

    private UUID serviceUUID = UUID.fromString("65786365-6c70-6f69-6e74-2e636f810000");
    private UUID characteristicUUID = UUID.fromString("65786365-6c70-6f69-6e74-2e636f810001");
//    private UUID descriptorsUUID = UUID.fromString("0x2902");

//    private UUID serviceUUID = UUID.fromString("65786365-6c70-6f69-6e74-2e636f6d0000");
//    private UUID characteristicUUID = UUID.fromString("65786365-6c70-6f69-6e74-2e636f6d0001");

//    private UUID serviceUUID = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
//    private UUID characteristicUUID = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");

    private static final String TAG = "BLEService";

    private LocalBroadcastManager localBroadcastManager;

    private BLEBinder bleBinder = new BLEBinder();

    private Intent intent;

    private static boolean isBLESuccess = false;

    private BluetoothGattCharacteristic gattCharacteristics;

    public BLEService() {
    }

    public class BLEBinder extends Binder {
        public void startScan() {
            Log.i(TAG, "startScan: 开始扫描");
            BLEfind();
        }

        public void connectBLE(String mac) {
            Log.i(TAG, "connectBLE: 开始连接");
            BLEConnect(mac);
        }

        public List<BluetoothLeDevice> getBluetoothLeDeviceList() {
            return bluetoothLeDeviceList;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e(TAG, "onBind: ");
        return bleBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: qidong");
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        bluetoothLeDeviceStore = new BluetoothLeDeviceStore();
    }


    //自定义的扫描方式，基本能满足大部分需求
    private ScanCallback periodScanCallback = new ScanCallback(new IScanCallback() {
        @Override
        public void onDeviceFound(BluetoothLeDevice bluetoothLeDevice) {
            Log.i(TAG, "找到新设备 " + bluetoothLeDevice);
            if (bluetoothLeDeviceStore != null) {
                bluetoothLeDeviceStore.addDevice(bluetoothLeDevice);
                bluetoothLeDeviceList = bluetoothLeDeviceStore.getDeviceList();
                addBroadcast("com.example.broadcasttest.DEVICE_FOUND");
            }
        }

        @Override
        public void onScanFinish(BluetoothLeDeviceStore bluetoothLeDeviceStore) {
            Log.i(TAG, "扫描结束 " + bluetoothLeDeviceStore.getDeviceList());
        }

        @Override
        public void onScanTimeout() {
            Log.i(TAG, "扫描超时 ");
        }
    });

    public void BLEfind() {
        if (bluetoothLeDeviceStore != null) {
            bluetoothLeDeviceStore.clear();
        }
        if (adapter != null && bluetoothLeDeviceList != null) {
            bluetoothLeDeviceList.clear();
            adapter.setDeviceList(bluetoothLeDeviceList);
        }
        ViseBle.getInstance().startScan(periodScanCallback);
    }



    //BLE连接指定地址的设备
    public void BLEConnect(String mac) {

        stopScan();
        addBroadcast("com.example.broadcasttest.CONNECTING");
        ViseBle.getInstance().connectByMac(mac, iConnectCallback);

    }

    private Toast showToash(String string) {
        Toast toast = new Toast(BLEService.this);
        toast.setText(string);
        return toast;
    }

    /**
     * 连接回调
     */
    private IConnectCallback iConnectCallback = new IConnectCallback() {
        @Override
        public void onConnectSuccess(final DeviceMirror deviceMirror) {
            Log.e(TAG, "onSuccess: Connect");
            addBroadcast("com.example.broadcasttest.CONNECTED");

//            Log.e(TAG, "onConnectSuccess: " + gatt.getDevice().getName());
//            if (gatt.getDevice().getName().equals("MGA1000")) {
//                gattCharacteristics = gatt.getService(serviceUUID).getCharacteristic(characteristicUUID);
//                ViseBluetooth.getInstance().enableCharacteristicNotification(gattCharacteristics,iCharacteristicCallback,false);
//            }

            BluetoothGattChannel bluetoothGattChannel = new BluetoothGattChannel.Builder()
                    .setBluetoothGatt(deviceMirror.getBluetoothGatt())
                    .setPropertyType(PropertyType.PROPERTY_INDICATE)
                    .setServiceUUID(serviceUUID)
                    .setCharacteristicUUID(characteristicUUID)
                    .builder();
            deviceMirror.bindChannel(new IBleCallback() {
                @Override
                public void onSuccess(byte[] data, BluetoothGattChannel bluetoothGattChannel, BluetoothLeDevice bluetoothLeDevice) {
                    Log.e(TAG, "BluetoothGattChannel succeess: ");
                    isBLESuccess = true;
                    deviceMirror.setNotifyListener(bluetoothGattChannel.getGattInfoKey(), new IBleCallback() {
                        @Override
                        public void onSuccess(byte[] data, BluetoothGattChannel bluetoothGattChannel, BluetoothLeDevice bluetoothLeDevice) {
                            Log.d(TAG, "onSuccessNotify: " + HexUtil.encodeHexStr(data));
                            if (HexUtil.encodeHexStr(data).equals("a00201a3") || HexUtil.encodeHexStr(data).equals("84") || HexUtil.encodeHexStr(data).equals("(0x) A0-02-01-A3")){
                                addBroadcast("com.example.broadcasttest.NOTIFY");
                            }
                        }

                        @Override
                        public void onFailure(BleException exception) {

                        }
                    });
                }

                @Override
                public void onFailure(BleException exception) {
                    Log.e(TAG, "BluetoothGattChannel Failure: ");
                }
            }, bluetoothGattChannel);
            deviceMirror.registerNotify(false);



        }

        @Override
        public void onConnectFailure(BleException exception) {
            Log.e(TAG, "onConnectFailure: ");
//            kProgressHUD.dismiss();
            addBroadcast("com.example.broadcasttest.CONNECT_FAILURE");
//            Toast.makeText(BLEService.this, "连接失败，请重试！", Toast.LENGTH_SHORT).show();
            isBLESuccess = false;
        }

        @Override
        public void onDisconnect(boolean isActive) {
            Log.e(TAG, "onDisconnect: ");
            addBroadcast("com.example.broadcasttest.DISCONNECT");
            isBLESuccess = false;
        }
    };
//    {
//        @Override
//        public void onConnectSuccess(BluetoothGatt gatt, int status) {
//            Log.e(TAG, "onSuccess: Connect");
////            kProgressHUD.dismiss();
//            Toast.makeText(BLEService.this,"连接成功", Toast.LENGTH_SHORT).show();
//            addBroadcast("com.example.broadcasttest.CONNECTED");
//
//            Log.e(TAG, "onConnectSuccess: " + gatt.getDevice().getName());
////            if (gatt.getDevice().getName().equals("MGA1000")) {
////                gattCharacteristics = gatt.getService(serviceUUID).getCharacteristic(characteristicUUID);
////                ViseBluetooth.getInstance().enableCharacteristicNotification(gattCharacteristics,iCharacteristicCallback,false);
////            }
//            isBLESuccess = true;
//
//        }
//
//        @Override
//        public void onConnectFailure(BleException exception) {
//            Log.e(TAG, "onConnectFailure: ");
////            kProgressHUD.dismiss();
//            addBroadcast("com.example.broadcasttest.CONNECT_FAILURE");
//            Toast.makeText(BLEService.this,"连接失败，请重试！", Toast.LENGTH_SHORT).show();
//            isBLESuccess = false;
//        }
//
//        @Override
//        public void onDisconnect() {
//            Log.e(TAG, "onDisconnect: ");
//            addBroadcast("com.example.broadcasttest.DISCONNECT");
//            isBLESuccess = false;
//        }
//    };



    public static boolean isBleSuccess() {
        return isBLESuccess;
    }

    private void addBroadcast(String action) {
        Intent intent = new Intent(action);
        localBroadcastManager.sendBroadcast(intent);
    }

    /**
     * 停止扫描，可以不用区分版本，这里是方便演示
     */
    private void stopScan() {
        ViseBle.getInstance().stopScan(periodScanCallback);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind: ");
        super.onRebind(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
