package com.drteam.gifsemoji.API;

import com.drteam.gifsemoji.models.searchdetail.Data;
import com.drteam.gifsemoji.models.searchdetail.Meta;
import com.drteam.gifsemoji.models.searchdetail.Pagination;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DuongKK on 9/12/2016.
 * T : type of response object in each API. maybe List or object.
 * Should be T . Cause API Provider do not respone the same object in "data". Some api response Object Data, some response List<data> .
 * So, we need define a common respone key here!
 */

public class ApiResponse<T>{

    @SerializedName("data")
    @Expose
    private T data = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
