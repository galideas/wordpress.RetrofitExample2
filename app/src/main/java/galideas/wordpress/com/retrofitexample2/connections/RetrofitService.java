package galideas.wordpress.com.retrofitexample2.connections;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Galideas on 18/06/2017.
 */

public interface RetrofitService {

    @GET("users/{user}/repos")
    Call<List<Repository>> loadUserRepository(@Path("user") String user);

}
