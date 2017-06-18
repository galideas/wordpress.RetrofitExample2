package galideas.wordpress.com.retrofitexample2.connections;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Antonio on 18/06/2017.
 */

public class Repository {

    @SerializedName("full_name")
    private String fullName;
    private long id;

    public String getFullName() {
        return fullName;
    }

    public long getId() {
        return id;
    }
}
