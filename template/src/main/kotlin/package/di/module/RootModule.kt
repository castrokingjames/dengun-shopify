package @{PACKAGE_NAME}.di.module

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import @{PACKAGE_NAME}.RootActivity
import @{PACKAGE_NAME}.feature.user.detail.UserDetailFragment
import @{PACKAGE_NAME}.feature.user.detail.di.component.UserDetailSubComponent
import @{PACKAGE_NAME}.feature.user.list.UserListFragment
import @{PACKAGE_NAME}.feature.user.list.di.component.UserListSubComponent

@Module(
        subcomponents = [
            UserListSubComponent::class,
            UserDetailSubComponent::class
        ]
)
abstract class RootModule {

    @Binds
    @IntoMap
    @ClassKey(UserListFragment::class)
    abstract fun bindUserListSubComponentFactory(factory: UserListSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(UserDetailFragment::class)
    abstract fun userDetailSubComponentFactory(factory: UserDetailSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    abstract fun bindActivity(factory: RootActivity): Activity
}