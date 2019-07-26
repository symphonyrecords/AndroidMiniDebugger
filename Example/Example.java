package com.symphonyrecords.debugger;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.symphonyrecords.debugger.DebuggerService;


public class MainActivity extends Activity {

    public final static int Overlay_REQUEST_CODE = 251;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkDrawOverlayPermission(this);
    }


    public void checkDrawOverlayPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                if (null != activity) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                    activity.startActivityForResult(intent, Overlay_REQUEST_CODE);
                } else {
                    Toast.makeText(this, "Please grant \"Draw over other apps\" permission under application settings", Toast.LENGTH_LONG).show();
                }
            } else {
                openFloatingWindow();
            }
        } else {
            openFloatingWindow();
        }
    }

    private void openFloatingWindow() {
        Intent intent = new Intent(this, DebuggerService.class);
        this.stopService(intent);
        ContextCompat.startForegroundService(this, intent);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == Overlay_REQUEST_CODE) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(this)) {
                        openFloatingWindow();
                    }
                } else {
                    openFloatingWindow();
                }
            }
        }
    }


}
