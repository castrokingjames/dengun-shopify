package @{PACKAGE_NAME}.manager.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import @{PACKAGE_NAME}.dispatcher.DispatcherManager

class AndroidDispatcherManager : DispatcherManager {
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}