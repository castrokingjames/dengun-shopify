package @{PACKAGE_NAME}.data.remote

import kotlinx.coroutines.delay
import @{PACKAGE_NAME}.data.UserData
import @{PACKAGE_NAME}.data.store.UserDataStore

class RemoteUserDataStore : UserDataStore {

    override suspend fun load(): List<UserData> {
        // assuming that network call is 1 second
        delay(1000L)
        return mutableListOf(
                UserData(1, "Liam"),
                UserData(2, "Noah"),
                UserData(3, "Oliver"),
                UserData(4, "William"),
                UserData(5, "Elijah"),
                UserData(6, "James"),
                UserData(7, "Benjamin"),
                UserData(8, "Lucas"),
                UserData(9, "Mason"),
                UserData(10, "Ethan")
        )
    }

    override suspend fun save(users: List<UserData>) {
        throw UnsupportedOperationException("save() is not supported")
    }

    override suspend fun loadById(id: Long): UserData? {
        throw UnsupportedOperationException("loadById() is not supported")
    }
}