package com.mia.ysc.common.eventbus

import com.mia.ysc.common.observer.BaseObservable

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
class EventBus : BaseObservable<EventBus.EventBusListener>() {

    interface EventBusListener {
        fun onEvent(event: Any)
    }

    fun postEvent(event: Any) {
        for (listener in getObserver()) {
            listener.onEvent(event)
        }
    }
}