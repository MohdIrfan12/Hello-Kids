package com.mia.ysc.ui.address

import android.os.Bundle
import android.widget.FrameLayout
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory

class AddressActivity : BaseActivity(), AddressView.Listener, TTSFactory.Listener {

    private lateinit var mAddressView: AddressView
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAddressView =
            getControllerCompositionRoot().getViewFactory().getAddressView(null)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mAddressView.getViewBinding().root)
    }

    override fun onTTSinitialized() {}

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        mAddressView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mAddressView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun onNavigationUpClicked() {
        finish()
    }
}