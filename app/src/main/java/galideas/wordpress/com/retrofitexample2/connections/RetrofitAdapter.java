package galideas.wordpress.com.retrofitexample2.connections;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Galideas on 18/06/2017.
 */

public class RetrofitAdapter {

    Retrofit retrofit;

    public RetrofitAdapter(){
    }

    public Retrofit getAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
