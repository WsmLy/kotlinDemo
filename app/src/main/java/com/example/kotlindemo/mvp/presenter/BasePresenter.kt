package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.mvp.model.IModel
import com.example.kotlindemo.mvp.view.IView
import java.lang.ref.WeakReference

abstract class BasePresenter<T : IView, K : IModel> : IPresenter<T> {
    var model: K? = null
    var weakReference: WeakReference<T>? = null

    override fun attachView(v: T) {
        weakReference = WeakReference(v)
        model ?: createModule()
    }

    override fun detachView() {
        if (isViewAttached()) {
            weakReference?.clear()
            weakReference = null
        }
        model?.unSubscribe()
        model = null
    }

    override fun isViewAttached(): Boolean {
        return weakReference?.get() != null;
    }

    fun getView(): T? {
        return weakReference?.get()
    }

    fun showLoading() {
        if (isViewAttached()) {
            getView()?.showLoading()
        }
    }

    fun dismissLoading() {
        if (isViewAttached()) {
            getView()?.dismissLoading()
        }
    }

    fun onSuccess() {
        if (isViewAttached()) {
            getView()?.onSuccess()
        }
    }

    fun onFailed(ex: Throwable, code: String, msg: String) {
        if (isViewAttached()) {
            getView()?.onFailed(ex, code, msg)
        }
    }

    fun onNetError() {
        if (isViewAttached()) {
            getView()?.onNetError()
        }
    }

    abstract fun createModule(): K
}