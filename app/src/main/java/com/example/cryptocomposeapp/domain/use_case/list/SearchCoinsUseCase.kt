package com.example.cryptocomposeapp.domain.use_case.list

import com.example.cryptocomposeapp.domain.model.ListCoins
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCoinsUseCase @Inject constructor(
    private val repositoryCoin: RepositoryCoins
) {
    operator fun invoke(query : String): Flow<Resource<List<ListCoins>>> {
        if (query.isBlank()) {
            return flow { }
        }
        return repositoryCoin.searchCoins(query)
    }
}