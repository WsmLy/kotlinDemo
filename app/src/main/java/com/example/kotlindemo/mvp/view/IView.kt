package com.example.kotlindemo.mvp.view

interface IView {

    fun showLoading()

    fun dismissLoading()

    fun onSuccess()

    fun onFailed(ex: Throwable, code: String, msg: String)

    fun onNetError()
}