package com.example.kotlindemo.mvp

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IApiService {
    /**
     * 测试
     */
    @POST("")
    fun login(@Body params: Map<*, *>?): Observable<BaseResponse<Test?>?>?
}