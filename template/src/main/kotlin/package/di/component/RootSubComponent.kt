package @{PACKAGE_NAME}.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import @{PACKAGE_NAME}.RootActivity
import @{PACKAGE_NAME}.di.module.DispatcherModule
import @{PACKAGE_NAME}.di.module.NavigationModule
import @{PACKAGE_NAME}.di.module.RootModule
import @{PACKAGE_NAME}.di.module.UserModule
import @{PACKAGE_NAME}.di.scope.ForActivity

@ForActivity
@Subcomponent(
        modules = [
            RootModule::class,
            DispatcherModule::class,
            UserModule::class,
            NavigationModule::class
        ]
)
interface RootSubComponent : AndroidInjector<RootActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RootActivity>
}