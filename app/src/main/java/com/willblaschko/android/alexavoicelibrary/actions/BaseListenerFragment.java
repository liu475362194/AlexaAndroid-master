package com.willblaschko.android.alexavoicelibrary.actions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.willblaschko.android.alexa.AlexaManager;
import com.willblaschko.android.alexa.callbacks.AsyncCallback;
import com.willblaschko.android.alexa.interfaces.AvsResponse;
import com.willblaschko.android.alexavoicelibrary.BLEConnect2Activity;
import com.willblaschko.android.alexavoicelibrary.R;
import com.willblaschko.android.alexavoicelibrary.Service.BLEService;

import static com.willblaschko.android.alexa.interfaces.response.ResponseParser.TAG;
import static com.willblaschko.android.alexavoicelibrary.global.Constants.PRODUCT_ID;

/**
 * @author will on 5/30/2016.
 */

public abstract class BaseListenerFragment extends Fragment {

    protected AlexaManager alexaManager;
    private LocalBroadcastManager localBroadcastManager;
    private MenuItem menuItem;
    private IntentFilter intentFilter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());

        //get our AlexaManager instance for convenience
        alexaManager = AlexaManager.getInstance(getActivity(), PRODUCT_ID);

        setHasOptionsMenu(true);

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.CONNECTED");
        ConnectReceiver connectReceiver = new ConnectReceiver();
        localBroadcastManager.registerReceiver(connectReceiver,intentFilter);




        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.DISCONNECTED");
        DisconnectReceiver disconnectReceiver = new DisconnectReceiver();
        localBroadcastManager.registerReceiver(disconnectReceiver,intentFilter);
    }

    class ConnectReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
        if (menuItem != null) {
            menuItem.setIcon(R.drawable.home_connect_pressed);
        }
        }
    }

    class DisconnectReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (menuItem != null){
                menuItem.setIcon(R.drawable.home_disconnected_pressed);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getActivity() != null) {
            getActivity().setTitle(getTitle());
        }
    }

    protected AsyncCallback<AvsResponse, Exception> getRequestCallback(){
        if(getActivity() != null && getActivity() instanceof AvsListenerInterface){
            return ((AvsListenerInterface) getActivity()).getRequestCallback();
        }
        return null;
    }





    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.code_menu, menu);
        menu.removeItem(0);
        menuItem = menu.add(Menu.NONE,Menu.FIRST,Menu.FIRST, null);
//        Log.d(TAG, "onCreate:isConnected() " + ViseBluetooth.getInstance().isConnected());
        if (BLEService.isBleSuccess()) {
            if (menuItem != null) {
                menuItem.setIcon(R.drawable.home_connect_pressed);
            }
        }else{
            menuItem.setIcon(R.drawable.home_disconnected_pressed);
        }

        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.view_code:
                Intent intent = new Intent(getContext(), BLEConnect2Activity.class);
                getContext().startActivity(intent);
                return true;
//        }
//        return super.onOptionsItemSelected(item);
    }

    public abstract void startListening();
    protected abstract String getTitle();
    @RawRes
    protected abstract int getRawCode();

    public interface AvsListenerInterface{
        AsyncCallback<AvsResponse, Exception> getRequestCallback();
    }

    protected void loadFragment(Fragment fragment){
        if(getActivity() != null && getActivity() instanceof ActionsFragment.ActionFragmentInterface){
            ((ActionsFragment.ActionFragmentInterface) getActivity()).loadFragment(fragment, true);
        }
    }
}
