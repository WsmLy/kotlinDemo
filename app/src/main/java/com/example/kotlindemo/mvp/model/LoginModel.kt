package com.example.kotlindemo.mvp.model

import com.example.kotlindemo.mvp.LoginContract
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class LoginModel : BaseModel(), LoginContract.Model {
    override fun login(map: Map<*, *>?, subscriber: Subscriber?) {
        val subscription: Subscription =
            api.login(map).compose(RetrofitHelper.applySchedulers()).subscribe(subscriber)
        addSubscribe(subscription)
    }
}