package @{PACKAGE_NAME}

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import @{PACKAGE_NAME}.di.component.Dagger@{PROJECT_NAME}Component
import @{PACKAGE_NAME}.di.module.ApplicationModule
import javax.inject.Inject

class @{PROJECT_NAME}Application : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        Dagger@{PROJECT_NAME}Component
                .factory()
                .create(ApplicationModule(this), this)
                .inject(this)
    }
}