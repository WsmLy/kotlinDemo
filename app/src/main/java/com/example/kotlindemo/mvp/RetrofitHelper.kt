package com.example.kotlindemo.mvp

import android.icu.util.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitHelper private constructor() {
    private var mOkHttpClient: OkHttpClient? = null
    private fun initOkHttpClient() {
        val logging = HttpLoggingInterceptor {
                message -> Timber.tag("Retrofit").e(message)
        }
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        if (mOkHttpClient == null) {
            synchronized(RetrofitHelper::class.java) {
                if (mOkHttpClient == null) {
//                    File cacheFile = new File(FltApplication.getInstance().getCacheDir(), "HttpCache");
//                    //100Mb
//                    Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
                    mOkHttpClient = OkHttpClient.Builder()
                        .retryOnConnectionFailure(false)
                        .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
                        .writeTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
                        .readTimeout(
                            30,
                            java.util.concurrent.TimeUnit.SECONDS
                        ) //                            .cache(cache)
                        .addInterceptor(HeaderInterceptor())
                        .addInterceptor(logging)
                        .build()
                }
            }
        }
    }

    fun createApiService(baseUrl: String): IApiService {
        return getRetrofit(baseUrl).create(IApiService::class.java)
    }

    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    companion object {
        private var sRetrofitHelper: RetrofitHelper? = null
        val instance: RetrofitHelper?
            get() {
                if (sRetrofitHelper == null) {
                    synchronized(RetrofitHelper::class.java) {
                        if (sRetrofitHelper == null) {
                            sRetrofitHelper = RetrofitHelper()
                        }
                    }
                }
                return sRetrofitHelper
            }
    }

    init {
        initOkHttpClient()
    }
}