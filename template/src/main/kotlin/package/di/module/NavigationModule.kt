package @{PACKAGE_NAME}.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import @{PACKAGE_NAME}.navigation.@{PROJECT_NAME}Navigation
import @{PACKAGE_NAME}.ui.navigation.Navigation

@Module
class NavigationModule {

    @Provides
    fun providesNavigation(activity: Activity): Navigation {
        return @{PROJECT_NAME}Navigation(activity)
    }
}