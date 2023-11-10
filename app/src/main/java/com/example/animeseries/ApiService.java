package com.example.animeseries;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1.4/movie?token=6H5E8VR-C8AME3F-NT73Q1F-GRX4DZV&limit=30&type=anime&isSeries=true" +
            "&rating.kp=7.8-10")
    Single<AnimeResponse> loadAnime(@Query("page") int page);

}
