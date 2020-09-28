package com.dengun.shopify.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherManager {

    val main: CoroutineDispatcher

    val io: CoroutineDispatcher
}