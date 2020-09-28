package com.dengun.shopify.manager.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.dengun.shopify.dispatcher.DispatcherManager

class AndroidDispatcherManager : DispatcherManager {
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}