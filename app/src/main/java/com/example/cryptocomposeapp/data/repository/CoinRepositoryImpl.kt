package com.example.cryptocomposeapp.data.repository

import com.example.cryptocomposeapp.data.local.Database
import com.example.cryptocomposeapp.data.mapper.toCoins
import com.example.cryptocomposeapp.data.mapper.toListCoinsEntity
import com.example.cryptocomposeapp.data.remote.api.CoinApi
import com.example.cryptocomposeapp.data.remote.model.CoinItemDetailModel
import com.example.cryptocomposeapp.data.remote.model.toListCoins
import com.example.cryptocomposeapp.domain.model.ListCoins
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi,
    db: Database
) : RepositoryCoins {

    private val dao = db.daoCoins
    override fun getListCoins(): Flow<Resource<List<ListCoins>>> = flow {
        try {
            emit(Resource.Loading())
            val listCoins = api.getListCoins().map { it.toListCoins() }.take(101)
            dao.insertCoins(listCoins.map { it.toListCoinsEntity() })
            emit(Resource.Success(data = listCoins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }

    override fun searchCoins(query: String): Flow<Resource<List<ListCoins>>> = flow {
        emit(Resource.Loading(true))
        val searchCoins = dao.searchCoins(query)
        emit(Resource.Success(searchCoins.map { it.toCoins() }))

        val isDbEmpty = searchCoins.isEmpty() && query.isBlank()
        val shouldJustLoadFromCache = !isDbEmpty
        if (shouldJustLoadFromCache) {
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun getDetailCoin(id: String): CoinItemDetailModel {
        return api.getItemDetailCoin(id)
    }
}