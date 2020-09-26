package @{PACKAGE_NAME}.feature.user.detail.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import @{PACKAGE_NAME}.di.scope.ForFragment
import @{PACKAGE_NAME}.feature.user.detail.UserDetailFragment
import @{PACKAGE_NAME}.feature.user.detail.di.module.AssistedModule

@ForFragment
@Subcomponent(
        modules = [
            AssistedModule::class
        ]
)
interface UserDetailSubComponent : AndroidInjector<UserDetailFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<UserDetailFragment>
}