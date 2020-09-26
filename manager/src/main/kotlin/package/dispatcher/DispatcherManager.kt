package @{PACKAGE_NAME}.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherManager {

    val main: CoroutineDispatcher

    val io: CoroutineDispatcher
}