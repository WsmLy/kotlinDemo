package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.mvp.LoginContract
import com.example.kotlindemo.mvp.model.LoginModel

class LoginPresenter : BasePresenter<LoginContract.View, LoginContract.Model>(),
    LoginContract.Presenter {
    override fun createModule(): LoginContract.Model {
        return LoginModel()
    }

    override fun login(phone: String, password: String) {
        showLoading()
        val params: MutableMap<String, String> = HashMap()
        params["phone"] = phone
        params["password"] = password

        model?.login(params, BaseSubscriber<UserInfo>(object : CallBackListener<UserInfo?>() {
            fun onSuccess(code: String?, data: UserInfo?) {
                dismissLoading()
                if (isViewAttach()) {
                    getView()!!.onLoginSuccess(data)
                }
            }

            fun onFailed(ex: Throwable?, code: String?, msg: String?) {
                dismissLoading()
                if (isViewAttach()) {
                    getView().onLoginFail(ex, code, msg)
                }
            }

            fun onError() {
                onNetError()
            }
        }))
    }
}