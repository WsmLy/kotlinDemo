package com.example.kotlindemo.mvp

import android.widget.TextView
import com.example.kotlindemo.R
import com.example.kotlindemo.mvp.presenter.LoginPresenter


class MVPActivity : BaseMVPActivity<LoginPresenter?>(), LoginContract.View {
    @BindView(R.id.tv_service)
    var tvService: TextView? = null
    private val userInfo: UserInfo? = null
    protected val layoutId: Int
        protected get() = R.layout.activity_m_v_p

    protected fun createPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    protected fun initView() {
        addHeadTitle("登陆")
    }

    @OnClick([R.id.login, R.id.register])
    fun onViewClicked(view: LoginContract.View) {
        when (view.getId()) {
            R.id.login -> mPresenter.login(phone, password)
            R.id.register -> {
            }
        }
    }

    override fun onLoginSuccess(data: UserInfo?) {
        // 登陆成功回调
    }

    fun onLoginFail(ex: Throwable?, code: String?, msg: String?) {
        // 登陆失败回调
    }
}