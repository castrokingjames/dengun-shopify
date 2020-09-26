package @{PACKAGE_NAME}.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import @{PACKAGE_NAME}.data.UserData
import @{PACKAGE_NAME}.data.store.UserDataStore
import @{PACKAGE_NAME}.domain.User
import @{PACKAGE_NAME}.domain.repository.UserRepository

class UserDataRepository(private val userDataStoreFactory: UserDataStore.Factory) : UserRepository {

    override suspend fun load(): Flow<List<User>> {
        return flow {
            loadFromLocal()
                    .ifEmpty {
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                    }
                    .map {
                        toUser(it)
                    }
                    .apply {
                        emit(this)
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                                .map {
                                    toUser(it)
                                }
                                .apply {
                                    emit(this)
                                }
                    }
        }
    }

    override suspend fun loadById(id: Long): User? {
        val local = userDataStoreFactory.createLocalDataStore()
        return local.loadById(id)?.let { data -> toUser(data) }
    }

    private suspend fun loadFromNetwork(): List<UserData> {
        val remote = userDataStoreFactory.createRemoteDataStore()
        return try {
            remote.load()
        } catch (exception: Exception) {
            throw exception
        }
    }

    private suspend fun loadFromLocal(): List<UserData> {
        val local = userDataStoreFactory.createLocalDataStore()
        return local.load()
    }

    private suspend fun saveToLocal(data: List<UserData>) {
        val local = userDataStoreFactory.createLocalDataStore()
        local.save(data)
    }

    private fun toUser(data: UserData): User {
        val id = data.id
        val name = data.name
        return User(id, name)
    }
}