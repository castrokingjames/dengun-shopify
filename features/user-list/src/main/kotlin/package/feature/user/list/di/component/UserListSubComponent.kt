package @{PACKAGE_NAME}.feature.user.list.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import @{PACKAGE_NAME}.di.scope.ForFragment
import @{PACKAGE_NAME}.feature.user.list.UserListFragment
import @{PACKAGE_NAME}.feature.user.list.di.module.AssistedModule

@ForFragment
@Subcomponent(
        modules = [
            AssistedModule::class
        ]
)
interface UserListSubComponent : AndroidInjector<UserListFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<UserListFragment>
}