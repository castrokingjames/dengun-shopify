package @{PACKAGE_NAME}.di.module

import dagger.Module
import dagger.Provides
import @{PACKAGE_NAME}.di.scope.ForActivity
import @{PACKAGE_NAME}.dispatcher.DispatcherManager
import @{PACKAGE_NAME}.manager.dispatcher.AndroidDispatcherManager

@Module
class DispatcherModule {

    @Provides
    @ForActivity
    fun providesDispatcher(): DispatcherManager {
        return AndroidDispatcherManager()
    }
}