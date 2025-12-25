package com.iot.composeapp.domain

import android.content.Context
import androidx.lifecycle.LifecycleOwner

interface NetworkStateListener {
    fun observeNetworkState(context: Context,
                            lifecycleOwner: LifecycleOwner
    )
}