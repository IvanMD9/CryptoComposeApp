package com.example.cryptocomposeapp.domain.use_case

import com.example.cryptocomposeapp.data.remote.model.toListCoins
import com.example.cryptocomposeapp.domain.model.ListCoins
import com.example.cryptocomposeapp.domain.repository.RepositoryCoin
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListCoinsUseCase @Inject constructor(
    private val repositoryCoin: RepositoryCoin
) {
    operator fun invoke() : Flow<Resource<List<ListCoins>>> = flow {
        try {
            emit(Resource.Loading<List<ListCoins>>())
            val listCoins = repositoryCoin.getListCoins().map { it.toListCoins() }
            emit(Resource.Success<List<ListCoins>>(listCoins))
        } catch (e : HttpException) {
            emit(Resource.Error<List<ListCoins>>(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error<List<ListCoins>>("Check you connection Internet"))
        }
    }
}