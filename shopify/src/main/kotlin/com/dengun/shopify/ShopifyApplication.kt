package com.dengun.shopify

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import com.dengun.shopify.di.component.DaggerShopifyComponent
import com.dengun.shopify.di.module.ApplicationModule
import com.dengun.shopify.timber.LogcatTree
import com.facebook.stetho.Stetho
import timber.log.Timber
import javax.inject.Inject

class ShopifyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerShopifyComponent
                .factory()
                .create(ApplicationModule(this), this)
                .inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(LogcatTree())
            Stetho.initializeWithDefaults(this)
        }
    }
}