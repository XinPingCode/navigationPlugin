package navigationPlugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
//import sun.rmi.runtime.Log;
import android.app.Activity;
import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class navigationPlugin extends CordovaPlugin {
    private CallbackContext cbc;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.cbc = callbackContext;
        if (action.equals("baiDuMap")) {
            String orlat = args.getString(0);
            String orlon = args.getString(1);
            String delat = args.getString(2);
            String delon = args.getString(3);
            String option = args.getString(4);
            Log.v("v1",orlat+","+orlon+","+delat+","+delon+","+option);
            this.baiDuMap(orlat,orlon,delat,delon,option,this.cbc);
            return true;
        }else if(action.equals("gaoDeMap")){
            String orlat = args.getString(0);
            String orlon = args.getString(1);
            String delat = args.getString(2);
            String delon = args.getString(3);
            String option = args.getString(4);
            Log.v("v2",orlat+","+orlon+","+delat+","+delon+","+option);
            this.gaoDeMap(orlat,orlon,delat,delon,option,this.cbc);
            return true;
        }
        return false;
    }

    private void baiDuMap(String orlat , String orlon ,String delat , String delon ,String option, CallbackContext callbackContext ) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("baidumap://map/direction?origin="+orlat+","+orlon+"&destination="+delat+","+delon+"&mode="+option));
        this.cordova.startActivityForResult(this,intent,0);
        callbackContext.success("成功开启百度地图");
    }

    private void gaoDeMap(String orlat , String orlon ,String delat , String delon ,String option, CallbackContext callbackContext){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("amapuri://route/plan/?sid=BGVIS1&slat="+orlat+"&slon="+orlon+"&dlat="+delat+"&dlon="+delon+"&t="+option));
        this.cordova.startActivityForResult(this,intent,0);
        callbackContext.success("成功开启高德地图");
    }
}
