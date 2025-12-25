package com.iot.composeapp.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.iot.composeapp.domain.NetworkStateListener

class NetworkStateHandler: NetworkStateListener {

    override fun observeNetworkState(context: Context,
                                     lifecycleOwner: LifecycleOwner
    ) {

        Log.v("COMP", "Observing the Network State")
    }
}