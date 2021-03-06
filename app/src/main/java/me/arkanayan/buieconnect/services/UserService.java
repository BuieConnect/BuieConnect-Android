package me.arkanayan.buieconnect.services;

import me.arkanayan.buieconnect.ServiceGenerator;
import me.arkanayan.buieconnect.apis.UserApi;
import me.arkanayan.buieconnect.models.User;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by arka on 4/10/16.
 */
public class UserService {
    private final String TAG = this.getClass().getSimpleName();

    private UserApi mUser;

    public UserService(String authToken) {
        mUser = ServiceGenerator.createService(UserApi.class, authToken);
    }

    public Call<User> getUserCall() {

        return mUser.getUser();
    }

    public Call<User> updateUser(RequestBody user) {
        return mUser.updateUser(user);
    }
}
