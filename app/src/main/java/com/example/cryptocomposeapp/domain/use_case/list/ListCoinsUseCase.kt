package com.example.cryptocomposeapp.domain.use_case.list

import com.example.cryptocomposeapp.domain.model.ListCoins
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListCoinsUseCase @Inject constructor(
    private val repositoryCoin: RepositoryCoins
) {
    operator fun invoke(): Flow<Resource<List<ListCoins>>> {
        return repositoryCoin.getListCoins()
    }
}