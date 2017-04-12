package com.drteam.gifsemoji.API;

import com.drteam.gifsemoji.models.randomresult.RandomResult;
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


    /*
    parameters:
        q, s, tag : key word
        api_key: API KEY trong Constants.java
        limit: so ket qua image tra ra
        offset: chua hieu no la cai gi nhung cu de la 0
        rating: gom co: y,g, pg, pg-13 or r
        lang: ngon ngu dinh dang 2 ky tu VD VietNam: vi
        fmt: dinh dang response laf html hay json, mac dinh tra ra json
     */

    //Gifs
    //tìm kiếm dựa vào từ khóa
    @GET("v1/gifs/search")
    Call<SearchResult> getSearchByKeyResult(@Query("q") String searchKey,
                                            @Query("api_key") String apikey,
                                            @Query("limit") int limit,
                                            @Query("offset") int offset,
                                            @Query("rating") String rating,
                                            @Query("lang") String lang,
                                            @Query("fmt") String fmt);

    //ảnh gif trending
    @GET("v1/gifs/trending")
    Call<SearchResult> getSearchTrendingResult(@Query("api_key") String apikey,
                                               @Query("limit") int limit,
                                               @Query("rating") String rating,
                                               @Query("fmt") String fmt);

    //ảnh gif liên quan
    @GET("v1/gifs/translate")
    Call<SearchSingleResult> getSearchTranslateResult(@Query("s") String searchKey,
                                                      @Query("api_key") String apikey,
                                                      @Query("rating") String rating,
                                                      @Query("lang") String lang,
                                                      @Query("fmt") String fmt);

    @GET("v1/gifs/random")
    Call<RandomResult> getSearchRandomResult(@Query("tag") String searchKey,
                                                          @Query("api_key") String apikey,
                                                          @Query("rating") String rating,
                                                          @Query("fmt") String fmt);

    //tìm kiếm bởi 1 id
    @GET("v1/gifs/{gif_id}")
    Call<SearchSingleResult> getSearchByIdResult(@Path("gif_id") String gifId, @Query("api_key") String apikey);

    //fifID dạng a,b,c,d...
    //tìm kiếm bởi nhiều id
    @GET("v1/gifs")
    Call<SearchResult> getSearchByIdsResult(@Query("ids") List<String> gifIds, @Query("api_key") String apikey);



    //STICKER - anhr gif khoong co background
    @GET("v1/stickers/search")
    Call<SearchResult> getSearchByKeyStickerResult(@Query("q") String searchKey,
                                                   @Query("api_key") String apikey,
                                                   @Query("limit") int limit,
                                                   @Query("offset") int offset,
                                                   @Query("rating") String rating,
                                                   @Query("lang") String lang,
                                                   @Query("fmt") String fmt);

    @GET("v1/stickers/trending")
    Call<SearchResult> getSearchTrendingStickerResult(@Query("api_key") String apikey,
                                                      @Query("offset") int offset,
                                                      @Query("limit") int limit,
                                                      @Query("rating") String rating,
                                                      @Query("fmt") String fmt);

    @GET("v1/stickers/translate")
    Call<SearchSingleResult> getSearchTranslateStickerResult(@Query("s") String searchKey,
                                                      @Query("api_key") String apikey,
                                                      @Query("rating") String rating,
                                                      @Query("lang") String lang,
                                                      @Query("fmt") String fmt);

    @GET("v1/stickers/random")
    Call<RandomResult> getSearchRandomStickerResult(@Query("tag") String searchKey,
                                                    @Query("api_key") String apikey,
                                                    @Query("rating") String rating,
                                                    @Query("fmt") String fmt);
}

