package com.example.kotlindemo.mvp

import androidx.annotation.NonNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        // TODO
//        String accessToken = GlobleSettingData.getInstance().getAuthInfo().getAccessToken();
//        if (!TextUtils.isEmpty(accessToken)) {
//            builder.addHeader("x-ac-token-ticket", accessToken);
//        }
        return chain.proceed(builder.build())
    }
}