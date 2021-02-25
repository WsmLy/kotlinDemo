package com.example.kotlindemo.mvp.model

import org.reactivestreams.Subscription
import java.util.concurrent.Flow

interface IModel {
    fun unSubscribe()

    fun addSubscribe(subscription: Subscription)
}