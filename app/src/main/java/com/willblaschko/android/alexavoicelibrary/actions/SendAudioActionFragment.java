package com.willblaschko.android.alexavoicelibrary.actions;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vise.baseble.ViseBle;
import com.willblaschko.android.alexa.requestbody.DataRequestBody;
import com.willblaschko.android.alexavoicelibrary.BuildConfig;
import com.willblaschko.android.alexavoicelibrary.R;
import com.willblaschko.android.alexavoicelibrary.Service.BLEService;
import com.willblaschko.android.recorderview.RecorderView;

import java.io.IOException;
import java.util.ArrayList;

import ee.ioc.phon.android.speechutils.RawAudioRecorder;
import okio.BufferedSink;


/**
 * @author will on 5/30/2016.
 */

public class SendAudioActionFragment extends BaseListenerFragment {

    private static final String TAG = "SendAudioActionFragment";

    private final static int MY_PERMISSIONS_REQUEST_RECORD_AUDIO = 1;
    private static final int AUDIO_RATE = 16000;
    private AudioManager mAudioManager;
    private RawAudioRecorder recorder;
    private RecorderView recorderView;
    private BluetoothAdapter mBluetoothAdapter;
    private boolean isStartVoice = false;
    private StartSpeakReceiver startSpeakReceiver;
    private LocalBroadcastManager localBroadcastManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_action_audio, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        recorderView = (RecorderView) view.findViewById(R.id.recorder);
        recorderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recorder == null) {
                    startListening();
                }else{
                    stopListening();
                }
            }
        });

        initBlueToothHeadset(getActivity());
        initPermission();
        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.NOTIFY");
        startSpeakReceiver = new StartSpeakReceiver();
        localBroadcastManager.registerReceiver(startSpeakReceiver,intentFilter);
    }


    @Override
    public void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.RECORD_AUDIO)) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_REQUEST_RECORD_AUDIO);
            }
        }
    }


    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String permissions[] = {
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.MODIFY_AUDIO_SETTINGS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(getActivity(), perm)) {
                toApplyList.add(perm);
                //进入到这里代表没有权限.
            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(getActivity(), toApplyList.toArray(tmpList), 123);
        } else {

        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECORD_AUDIO: {
                // If request is cancelled, the result arrays are empty.
                if (!(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                }
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //tear down our recorder on stop
        if(recorder != null){
            recorder.stop();
            recorder.release();
            recorder = null;
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mLongClickBroadcastReceiver);
        localBroadcastManager.unregisterReceiver(startSpeakReceiver);
    }

    @Override
    public void startListening() {
        Log.e(TAG,"isStartVoice = " + isStartVoice + "Adapter.isEnabled = " + mBluetoothAdapter.isEnabled());
        if(!mBluetoothAdapter.isEnabled()){
            startSCOListening();
            return;
        }
        if (!mAudioManager.isBluetoothScoAvailableOffCall()) {
            Log.d(TAG, "系统不支持蓝牙录音");
            return;
        }

        Log.e(TAG, "startRecording");
        if (BLEService.isBleSuccess()){
            if(!isStartVoice){
                startRecording();
            }else{
                startSCOListening();
                Log.e(TAG, "startListening: recorder.start()2" + mAudioManager.isBluetoothScoOn());
            }
        }else {
//            Log.e(TAG, "mIsBluetoothConnect = " + ViseBluetooth.getInstance().getState());
            startSCOListening();
        }


    }

    private DataRequestBody requestBody = new DataRequestBody() {
        @Override
        public void writeTo(BufferedSink sink) throws IOException {
            while (recorder != null && !recorder.isPausing()) {
                if(recorder != null) {
                    final float rmsdb = recorder.getRmsdb();
//                    Log.i(TAG, "hjl rmsdb: " + rmsdb);
                    if(recorderView != null) {
                        recorderView.post(new Runnable() {
                            @Override
                            public void run() {

                                recorderView.setRmsdbLevel(rmsdb);
                            }
                        });
                    }
                    if(sink != null && recorder != null) {
                        sink.write(recorder.consumeRecording());
                    }
                    if(BuildConfig.DEBUG){
//                        Log.i(TAG, "Received audio");

                    }
                }

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
//                    e.printStackLog();
                    e.printStackTrace();
                }
            }
            stopListening();
        }

    };

    private void stopListening(){
        setBluetoothA2dpOn();
        if(recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
            stopSCO();
        }
        isStartVoice = false;
    }

    private void setBluetoothA2dpOn(){
        if (BLEService.isBleSuccess()){
            if (!mAudioManager.isBluetoothA2dpOn())
                mAudioManager.setBluetoothA2dpOn(true); // 如果A2DP没建立，则建立A2DP连接
            mAudioManager.stopBluetoothSco();// 如果SCO没有断开，由于SCO优先级高于A2DP，A2DP可能无声音
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mAudioManager.setStreamSolo(AudioManager.STREAM_MUSIC, true);
                    // 让声音路由到蓝牙A2DP。此方法虽已弃用，但就它比较直接、好用。
                    mAudioManager.setRouting(AudioManager.MODE_NORMAL,
                            AudioManager.ROUTE_BLUETOOTH_A2DP,
                            AudioManager.ROUTE_BLUETOOTH);
                }
            }).start();

        }
    }

    @Override
    protected String getTitle() {
        return getString(R.string.fragment_action_send_audio);
    }

    @Override
    protected int getRawCode() {
        return R.raw.code_audio;
    }

    private void stopSCO() {
        isStartVoice = false;
        if(mAudioManager.isBluetoothScoOn()){
            mAudioManager.setBluetoothScoOn(false);
            mAudioManager.stopBluetoothSco();
        }

        Log.e(TAG, "stopSCO: startListening: recorder.stop()");
    }


    private void initBlueToothHeadset(Context context){
        if(android.os.Build.VERSION.SDK_INT<android.os.Build.VERSION_CODES.JELLY_BEAN_MR2){//android4.3之前直接用BluetoothAdapter.getDefaultAdapter()就能得到BluetoothAdapter
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }else{
            BluetoothManager bm=(BluetoothManager) getActivity().getSystemService(Context.BLUETOOTH_SERVICE);
            mBluetoothAdapter = bm.getAdapter();
        }
        // 20171010 hjl add
//        final IntentFilter longClickFilter = new IntentFilter();
//        longClickFilter.addAction(Constant.ACTION_IS_LONG_CLICK);
//        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mLongClickBroadcastReceiver, longClickFilter);

    }

    class StartSpeakReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
//            Log.d(TAG, "onReceive: " + recorder);
            if(recorder == null) {
                startListening();
            }else{
                stopListening();
            }
        }
    }


    public void startSCOListening() {
        if(recorder == null){
            recorder = new RawAudioRecorder(AUDIO_RATE);
        }
        recorder.start();
        alexaManager.sendAudioRequest(requestBody, getRequestCallback());
    }

    /***********************************  2017/12/15 hjl ****************************************/
    // 二、录音
    public void startRecording() {
        mAudioManager.setMode(AudioManager.MODE_IN_CALL);
        //蓝牙录音的关键，启动SCO连接，耳机话筒才起作用
        Log.e(TAG,"startRecording 启动SCO连接");
        isStartVoice = true;
        mAudioManager.startBluetoothSco();
        //蓝牙SCO连接建立需要时间，连接建立后会发出ACTION_SCO_AUDIO_STATE_CHANGED消息，通过接收该消息而进入后续逻辑。
        //也有可能此时SCO已经建立，则不会收到上述消息，可以startBluetoothSco()前先stopBluetoothSco()
        getActivity().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int state = intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, -1);
                Log.e(TAG,"state = " + state);
                if (AudioManager.SCO_AUDIO_STATE_CONNECTED == state) {
                    mAudioManager.setBluetoothScoOn(true);  //打开SCO
                    mAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, 0);
                    Log.e(TAG,"isBluetoothScoOn = " + mAudioManager.isBluetoothScoOn());
                    if (mAudioManager.isBluetoothScoOn()) {

                        //  recorder.start();//开始录音
                        startSCOListening();
                    }

                    getActivity().unregisterReceiver(this);  //别遗漏
                }else{//等待一秒后再尝试启动SCO
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            mAudioManager.startBluetoothSco();
                        }
                    }).start();

                }
            }
        }, new IntentFilter(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED));
    }
}
