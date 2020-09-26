package @{PACKAGE_NAME}.feature.user.list.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_AssistedModule::class])
@AssistedModule
interface AssistedModule