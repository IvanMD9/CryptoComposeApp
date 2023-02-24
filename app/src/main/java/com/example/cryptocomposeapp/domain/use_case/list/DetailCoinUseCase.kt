package com.example.cryptocomposeapp.domain.use_case.list

import com.example.cryptocomposeapp.data.remote.model.toDetailCoin
import com.example.cryptocomposeapp.domain.model.CoinDetail
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DetailCoinUseCase @Inject constructor(
    private val repositoryCoin: RepositoryCoins
) {

    operator fun invoke(id : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val detailCoin = repositoryCoin.getDetailCoin(id).toDetailCoin()
            emit(Resource.Success(detailCoin))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}