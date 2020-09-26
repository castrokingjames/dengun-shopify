package @{PACKAGE_NAME}.di.module

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import @{PACKAGE_NAME}.RootActivity
import @{PACKAGE_NAME}.di.component.RootSubComponent

@Module(
        subcomponents = [
            RootSubComponent::class
        ]
)
abstract class @{PROJECT_NAME}Module {

    @Binds
    @IntoMap
    @ClassKey(RootActivity::class)
    abstract fun bindRootActivityInjectorFactory(factory: RootSubComponent.Factory): AndroidInjector.Factory<*>
}