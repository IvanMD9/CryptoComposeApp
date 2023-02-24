package com.example.cryptocomposeapp.domain.use_case.favourite

import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.repository.RepositoryFavouriteCoins
import javax.inject.Inject

class DeleteFavouriteUseCase @Inject constructor(
    private val repositoryFavouriteCoins: RepositoryFavouriteCoins
) {
    suspend operator fun invoke(favouriteCoin: FavouriteCoin) {
        return repositoryFavouriteCoins.deleteFavourite(favouriteCoin)
    }
}