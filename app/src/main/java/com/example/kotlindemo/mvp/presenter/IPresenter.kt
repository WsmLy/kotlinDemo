package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.mvp.view.IView

interface IPresenter<T: IView> {
    fun attachView(v: T)

    fun detachView()

    fun isViewAttached(): Boolean
}