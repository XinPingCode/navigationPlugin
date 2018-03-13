package navigationPlugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PermissionHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
//import sun.rmi.runtime.Log;
import android.app.Activity;
import android.util.Log;
import java.io.File;
import android.content.pm.PackageManager;
import android.Manifest;
import android.os.Build;

/**
 * This class echoes a string called from JavaScript.
 */
public class navigationPlugin extends CordovaPlugin {
    CallbackContext cbc;
    String[] permissions = { Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE };

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.cbc = callbackContext;
        if (action.equals("baiDuMap")) {
            String orlat = args.getString(0);
            String orlon = args.getString(1);
            String delat = args.getString(2);
            String delon = args.getString(3);
            String option = args.getString(4);
            Log.v("v1", orlat + "," + orlon + "," + delat + "," + delon + "," + option);
            this.baiDuMap(orlat, orlon, delat, delon, option, this.cbc);
            return true;
        } else if (action.equals("gaoDeMap")) {
            String orlat = args.getString(0);
            String orlon = args.getString(1);
            String delat = args.getString(2);
            String delon = args.getString(3);
            String option = args.getString(4);
            Log.v("v2", orlat + "," + orlon + "," + delat + "," + delon + "," + option);
            this.gaoDeMap(orlat, orlon, delat, delon, option, this.cbc);
            return true;
        } else if (action.equals("isInstallBaiduMap")) {
            String o1=args.getString(0);
            this.isInstallBaiduMap(this.cbc);
            return true;
        } else if (action.equals("isInstallGaodeMap")) {
            String o1=args.getString(0);
            this.isInstallGaodeMap(this.cbc);
            return true;
        }
        return false;
    }

    private void baiDuMap(String orlat, String orlon, String delat, String delon, String option,
            CallbackContext callbackContext) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("baidumap://map/direction?origin=" + orlat + "," + orlon + "&destination=" + delat
                + "," + delon + "&mode=" + option));
        this.cordova.startActivityForResult(this, intent, 0);
        callbackContext.success("成功开启百度地图");
    }

    private void gaoDeMap(String orlat, String orlon, String delat, String delon, String option,
            CallbackContext callbackContext) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("amapuri://route/plan/?sid=BGVIS1&slat=" + orlat + "&slon=" + orlon + "&dlat=" + delat
                + "&dlon=" + delon + "&t=" + option));
        this.cordova.startActivityForResult(this, intent, 0);
        callbackContext.success("成功开启高德地图");
    }

   
    private boolean isInstallMap(String packageName) {
         return new File("/data/data/" + packageName).exists();
    }

    private void isInstallBaiduMap(CallbackContext callbackContext) {

        getPermission();
        String backb="unknow";
        if (isInstallMap("com.baidu.BaiduMap")) {
            backb="true";
        } else {
            backb="false";
        }
        callbackContext.success(backb);
    }

    private void isInstallGaodeMap(CallbackContext callbackContext) {

        getPermission();
        String backa="unknow";
        if (isInstallMap("com.autonavi.minimap")) {
            backa="true";
        } else {
            backa="false";
        }
        callbackContext.success(backa);
    }

    public void getPermission() {
        if (hasPermisssion()) {
        } else {
            PermissionHelper.requestPermissions(this, 0, permissions);
        }
    }

    public boolean hasPermisssion() {
        for (String p : permissions) {
            if (!PermissionHelper.hasPermission(this, p)) {
                return false;
            }
        }
        return true;
    }
}
