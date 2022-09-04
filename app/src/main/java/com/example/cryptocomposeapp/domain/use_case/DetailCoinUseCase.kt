package com.example.cryptocomposeapp.domain.use_case

import com.example.cryptocomposeapp.data.remote.model.toDetailCoin
import com.example.cryptocomposeapp.domain.model.CoinDetail
import com.example.cryptocomposeapp.domain.repository.RepositoryCoin
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DetailCoinUseCase @Inject constructor(
    private val repositoryCoin: RepositoryCoin
) {

    operator fun invoke(id : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val detailCoin = repositoryCoin.getDetailCoin(id).toDetailCoin()
            emit(Resource.Success<CoinDetail>(detailCoin))
        } catch (e : HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error<CoinDetail>("Check you connection Internet"))
        }
    }
}