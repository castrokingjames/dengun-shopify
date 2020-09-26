package @{PACKAGE_NAME}.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import @{PACKAGE_NAME}.@{PROJECT_NAME}Application
import @{PACKAGE_NAME}.di.module.ApplicationModule
import @{PACKAGE_NAME}.di.module.@{PROJECT_NAME}Module
import @{PACKAGE_NAME}.di.scope.ForApplication
import javax.inject.Singleton

@ForApplication
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            @{PROJECT_NAME}Module::class
        ]
)
interface @{PROJECT_NAME}Component : AndroidInjector<@{PROJECT_NAME}Application> {

    @Component.Factory
    interface Factory {

        fun create(module: ApplicationModule, @BindsInstance application: Application): @{PROJECT_NAME}Component
    }

    override fun inject(app: @{PROJECT_NAME}Application)
}