package @{PACKAGE_NAME}.data.store

import @{PACKAGE_NAME}.data.UserData

interface UserDataStore {

    suspend fun load(): List<UserData>

    suspend fun save(users: List<UserData>)

    suspend fun loadById(id: Long): UserData?

    interface Factory {

        fun createLocalDataStore(): UserDataStore

        fun createRemoteDataStore(): UserDataStore
    }
}