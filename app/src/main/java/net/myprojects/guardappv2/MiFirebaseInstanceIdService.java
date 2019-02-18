package net.myprojects.guardappv2;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by PROBOOK G2 on 4/12/2018.
 */

public class MiFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String DeviceToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("DeviceToken ==> ",  DeviceToken);
    }
}
