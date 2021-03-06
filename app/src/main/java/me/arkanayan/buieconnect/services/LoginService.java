package me.arkanayan.buieconnect.services;


import android.util.Log;

import com.google.gson.Gson;

import me.arkanayan.buieconnect.ServiceGenerator;
import me.arkanayan.buieconnect.apis.LoginApi;
import me.arkanayan.buieconnect.models.AuthResponse;
import me.arkanayan.buieconnect.models.LoginToken;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by arka on 4/9/16.
 */
public class LoginService {

    private String TAG = this.getClass().getSimpleName();

    private LoginApi loginApi;

    public LoginService() {
        this.loginApi = ServiceGenerator.createService(LoginApi.class);
    }

    public Call<AuthResponse> getLoginCall(String idToken) {

        LoginToken token = new LoginToken(idToken);

        Gson gson = new Gson();
        String json = gson.toJson(token);
        Log.d(TAG, "doLogin: Gson json: " + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        Call<AuthResponse> responseCall = loginApi.login(requestBody);

        return responseCall;
    }


}
