package com.drteam.gifsemoji.API;

import android.content.Context;


import com.afollestad.materialdialogs.MaterialDialog;
import com.drteam.gifsemoji.R;
import com.drteam.gifsemoji.interfaces.OnResponse;
import com.drteam.gifsemoji.utils.RLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DuongKK on 11/6/2016.
 */

public class CallBackCustom<T> implements Callback<T> {
    OnResponse<T> t;
    //ProgressDialogCustom dialogCustom;
    Context context;

//    public CallBackCustom(Context context, ProgressDialogCustom dialogCustom, OnResponse<T> t) {
//        this.dialogCustom = dialogCustom;
//        this.t = t;
//        this.context = context;
//    }

    public CallBackCustom(Context context, OnResponse<T> t) {
        this.context = context;
        this.t = t;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
//        try {
////            if (dialogCustom != null)
////                dialogCustom.hideDialog();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        if (response.isSuccessful()) {
            t.onResponse(response.body());


        } else {
            //// TODO: 4/16/2017 Error . We need to inform to user check error here. Should be informed by dialog
            new    MaterialDialog.Builder(context).title("Error")
                    .content(String.format(context.getString(R.string.unknow_error_code),response.code()+""))
                    .build().show();
            RLog.e("Error onRespone " + response.code());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        //// TODO: 4/16/2017 Error . We need to inform to user check error here. Should be informed by dialog
//        try {
////            if (dialogCustom != null)
////                dialogCustom.hideDialog();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    new    MaterialDialog.Builder(context).title("Error")
            .content(String.format(context.getString(R.string.unknow_error_code),t.getMessage()))
            .build().show();
        RLog.e("error - callback " + t.getMessage());
    }
}
