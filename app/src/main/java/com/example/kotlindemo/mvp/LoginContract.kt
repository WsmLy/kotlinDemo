package com.example.kotlindemo.mvp

import com.example.kotlindemo.mvp.model.IModel
import com.example.kotlindemo.mvp.view.IView
import org.reactivestreams.Subscriber

interface LoginContract {
    interface View : IView {
        fun onLoginSuccess(data: UserInfo)

        fun onLoginFailed(ex: Throwable, code: String, msg: String)
    }

    interface Presenter {
        fun login(phone: String, password: String)
    }

    interface Model: IModel {
        fun login(map: Map<*, *>?, subscriber: Subscriber<*>?)
    }
}