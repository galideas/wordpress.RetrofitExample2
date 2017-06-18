package galideas.wordpress.com.retrofitexample2;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import galideas.wordpress.com.retrofitexample2.connections.Repository;
import galideas.wordpress.com.retrofitexample2.connections.RetrofitAdapter;
import galideas.wordpress.com.retrofitexample2.connections.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    Call<List<Repository>> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        Retrofit retrofit = new RetrofitAdapter().getAdapter();
        RetrofitService service = retrofit.create(RetrofitService.class);
            call = service.loadUserRepository("galideas");
            call.enqueue(new Callback<List<Repository>>() {
                @Override
                public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                    for (Repository repo : response.body()){
                        System.out.println(repo.getId() + ": " + repo.getFullName());
                    }
                }

                @Override
                public void onFailure(Call<List<Repository>> call, Throwable t) {
                    System.out.println(t.getCause().toString());
                }
            });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!call.isCanceled())
            call.cancel();
    }
}
