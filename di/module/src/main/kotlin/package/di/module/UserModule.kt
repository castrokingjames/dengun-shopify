package @{PACKAGE_NAME}.di.module

import dagger.Module
import dagger.Provides
import @{PACKAGE_NAME}.data.local.LocalUserDataStore
import @{PACKAGE_NAME}.data.remote.RemoteUserDataStore
import @{PACKAGE_NAME}.data.repository.UserDataRepository
import @{PACKAGE_NAME}.data.store.UserDataStore
import @{PACKAGE_NAME}.di.scope.ForActivity
import @{PACKAGE_NAME}.domain.repository.UserRepository
import javax.inject.Named

@Module
class UserModule {

    @Provides
    @ForActivity
    fun providesRepository(userDataStoreFactory: UserDataStore.Factory): UserRepository {
        return UserDataRepository(userDataStoreFactory)
    }

    @Provides
    fun providesDataStoreFactory(@Named("local") local: UserDataStore,
                                 @Named("remote") remote: UserDataStore): UserDataStore.Factory {
        return UserDataStoreFactory(local, remote)
    }

    @Provides
    @Named("local")
    fun providesLocalDataStore(): UserDataStore {
        return LocalUserDataStore()
    }

    @Provides
    @Named("remote")
    fun providesRemoteDataStore(): UserDataStore {
        return RemoteUserDataStore()
    }

    class UserDataStoreFactory(private val local: UserDataStore, private val remote: UserDataStore) : UserDataStore.Factory {

        override fun createLocalDataStore(): UserDataStore {
            return local
        }

        override fun createRemoteDataStore(): UserDataStore {
            return remote
        }
    }
}