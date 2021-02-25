package com.example.kotlindemo.mvp.model

import org.reactivestreams.Subscription

class BaseModel: IModel {

    var api: ApiService
    var compositeSubscription: CompositeSubscription = null

    fun BaseModel() {
        api = RetrofitHelper.getInstance().createApiService(AppConstants.BASE_SERVER_IP);
    }

    override fun unSubscribe() {
        if (!compositeSubscription.isUnsubscribed()) {
            compositeSubscription.clear();
            compositeSubscription.unsubscribe();
        }
    }

    override fun addSubscribe(subscription: Subscription) {
        compositeSubscription?= CompositeSubscription()
        compositeSubscription.add(subscription)
    }
}