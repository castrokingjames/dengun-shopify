package @{PACKAGE_NAME}.data.local

import android.util.Log
import @{PACKAGE_NAME}.data.UserData
import @{PACKAGE_NAME}.data.store.UserDataStore

class LocalUserDataStore : UserDataStore {

    // memory cache
    private val memory = hashMapOf<Long, UserData>()

    override suspend fun load(): List<UserData> {
        return memory
                .map { data -> data.value }
                .toList()
                .sortedBy { data -> data.name }
    }

    override suspend fun save(users: List<UserData>) {
        users.forEach { user ->
            memory[user.id] = user
        }
    }

    override suspend fun loadById(id: Long): UserData? {
        return memory[id]
    }
}