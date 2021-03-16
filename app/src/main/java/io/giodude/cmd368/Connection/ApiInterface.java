package io.giodude.cmd368.Connection;

import io.giodude.cmd368.Model.LiveModel;
import io.giodude.cmd368.Model.PastModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    String BASE_URL = "https://sportscore1.p.rapidapi.com/sports/1/";

    @GET("events/live")
    @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
    "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
    "useQueryString: true"})
    Call<LiveModel> getLive();

    String BASE_URL1 = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("eventspastleague.php?id=4328")
    Call<PastModel> getPast();
}
