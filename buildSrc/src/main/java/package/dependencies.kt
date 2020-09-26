package @{PACKAGE_NAME}

object Config {
    const val applicationId = "@{PACKAGE_NAME}"
    const val versionCode = 1
    const val versionName = "0.1"
    const val min = 21
    const val target = 29
    const val compile = 29
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.0.1"

    object Kotlin {
        private const val version = "1.3.50"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.3.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Material {
            const val material = "com.google.android.material:material:1.0.0"
        }

        object Navigation {
            private const val version = "2.1.0"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Room {
            private const val version = "2.1.0"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
        }
    }

    object Dagger {
        private const val version = "2.25.2"
        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object AssistedInject {
        private const val version = "0.5.0"
        const val annotationDagger2 = "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 = "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }

    object Retrofit {
        private const val version = "2.6.2"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.2.0"
    }

    object Airbnb {
        const val mvRx = "com.airbnb.android:mvrx:1.1.0"

        object Epoxy {
            private const val version = "3.8.0"
            const val epoxy = "com.airbnb.android:epoxy:$version"
            const val processor = "com.airbnb.android:epoxy-processor:$version"
        }
    }

    object Bumptech {
        const val glide = "com.github.bumptech.glide:glide:4.10.0"
    }
}