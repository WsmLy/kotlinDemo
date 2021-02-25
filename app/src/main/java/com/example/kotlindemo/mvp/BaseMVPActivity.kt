package com.example.kotlindemo.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.mvp.model.IModel
import com.example.kotlindemo.mvp.presenter.BasePresenter
import com.example.kotlindemo.mvp.view.IView

abstract class BaseMVPActivity<P: BasePresenter<IView, IModel>> : AppCompatActivity(), IView {

    var presenter: P? = null
    var unbinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initPreserter()
    }

    fun initPreserter() {
        presenter = createPresenter()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        presenter = null
        unbinder?.unbind()
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun onSuccess() {

    }

    override fun onFailed(ex: Throwable, code: String, msg: String) {

    }

    override fun onNetError() {

    }

    fun initData() {

    }

    abstract fun getLayoutId(): Int

    abstract fun createPresenter(): P

    abstract fun initView()
}