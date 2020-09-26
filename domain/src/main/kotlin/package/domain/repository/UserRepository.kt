package @{PACKAGE_NAME}.domain.repository

import kotlinx.coroutines.flow.Flow
import @{PACKAGE_NAME}.domain.User

interface UserRepository {

    suspend fun load(): Flow<List<User>>

    suspend fun loadById(id: Long): User?
}