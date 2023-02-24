package com.example.cryptocomposeapp.domain.use_case.favourite

import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.repository.RepositoryFavouriteCoins
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListFavouriteUseCase @Inject constructor(
    private val repositoryFavouriteCoins: RepositoryFavouriteCoins
) {
    operator fun invoke(): Flow<List<FavouriteCoin>> {
        return repositoryFavouriteCoins.getListFav()
    }
}