package auth.domain.repository

interface LoginRepository {

    suspend fun Login(email:String,password:String):Int
}