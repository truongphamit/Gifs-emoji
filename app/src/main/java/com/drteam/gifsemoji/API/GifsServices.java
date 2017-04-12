package com.drteam.gifsemoji.API;

import com.drteam.gifsemoji.models.searchdetail.SearchResult;
import com.drteam.gifsemoji.models.searchdetail.SearchSingleResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by CUONG-PH on 4/10/2017.
 */

public interface GifsServices {

    //tìm kiếm dựa vào từ khóa
    @GET("v1/gifs/search")
    Call<SearchResult> getSearchResult(@Query("q") String searchKey, @Query("api_key") String apikey, @Query("limit") int limit);

    //ảnh gif trending
    @GET("v1/gifs/trending")
    Call<SearchResult> getSearchTrendingResult(@Query("api_key") String apikey, @Query("limit") int limit);

    //ảnh gif liên quan
    @GET("v1/gifs/translate")
    Call<SearchSingleResult> getSearchTranslateResult(@Query("s") String searchKey, @Query("api_key") String apikey);

    //tìm kiếm bởi 1 id
    @GET("v1/gifs/{gif_id}")
    Call<SearchSingleResult> getSearchByIdResult(@Path("gif_id") String gifId, @Query("api_key") String apikey);

    //fifID dạng a,b,c,d...
    //tìm kiếm bởi nhiều id
    @GET("v1/gifs")
    Call<SearchResult> getSearchByIdsResult(@Query("ids") List<String> gifIds, @Query("api_key") String apikey);
}

