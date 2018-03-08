package com.willblaschko.android.alexavoicelibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.vise.baseble.ViseBle;
import com.willblaschko.android.alexavoicelibrary.actions.ActionsFragment;
import com.willblaschko.android.alexavoicelibrary.actions.BaseListenerFragment;

import static com.willblaschko.android.alexavoicelibrary.R.id.frame;

/**
 * Our main launch activity where we can change settings, see about, etc.
 */
public class MainActivity extends BaseActivity implements ActionsFragment.ActionFragmentInterface, FragmentManager.OnBackStackChangedListener {
    private final static String TAG = "MainActivity";
    private final static String TAG_FRAGMENT = "CurrentFragment";

    private View statusBar;
    private TextView status;
    private View loading;

//    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViseBle.getInstance().init(getApplicationContext());
        //Listen for changes in the back stack
//        getSupportFragmentManager().addOnBackStackChangedListener(this);
        //Handle when activity is recreated like on orientation Change
        shouldDisplayHomeUp();

        statusBar = findViewById(R.id.status_bar);
        status = (TextView) findViewById(R.id.status);
        loading = findViewById(R.id.loading);

        ActionsFragment fragment = new ActionsFragment();
        loadFragment(fragment, false);

//        localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.example.broadcasttest.START_SPEAK");
//        StartSpeakReceiver startSpeakReceiver = new StartSpeakReceiver();
//        localBroadcastManager.registerReceiver(startSpeakReceiver,intentFilter);
    }

//    class StartSpeakReceiver extends BroadcastReceiver{
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            startListening();
//        }
//    }

    @Override
    protected void startListening() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);
        if (fragment != null && fragment.isVisible()) {
            // add your code here
            if(fragment instanceof BaseListenerFragment){
                ((BaseListenerFragment) fragment).startListening();
            }
        }
    }

    @Override
    public void loadFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(frame, fragment, TAG_FRAGMENT);
        if(addToBackStack){
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    protected void stateListening(){

        if(status != null) {
            status.setText(R.string.status_listening);
            loading.setVisibility(View.GONE);
//            statusBar.animate().alpha(1);
            statusBar.setAlpha(1);
        }
    }
    protected void stateProcessing(){

        if(status != null) {
            status.setText(R.string.status_processing);
            loading.setVisibility(View.VISIBLE);
//            statusBar.animate().alpha(1);
            statusBar.setAlpha(1);
        }
    }
    protected void stateSpeaking(){

        if(status != null) {
            status.setText(R.string.status_speaking);
            loading.setVisibility(View.VISIBLE);
//            statusBar.animate().alpha(1);
            statusBar.setAlpha(1);
        }
    }
    protected void statePrompting(){

        if(status != null) {
            status.setText("");
            loading.setVisibility(View.VISIBLE);
//            statusBar.animate().alpha(1);
            statusBar.setAlpha(1);
        }
    }
    protected void stateFinished(){
        if(status != null) {
            status.setText("");
            loading.setVisibility(View.GONE);
//            statusBar.animate().alpha(0);
            statusBar.setAlpha(0);
        }
    }
    protected void stateNone(){
        statusBar.animate().alpha(0);
    }


    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = (getSupportFragmentManager().getBackStackEntryCount() > 0);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
        getSupportFragmentManager().popBackStack();
        return true;
    }
}
