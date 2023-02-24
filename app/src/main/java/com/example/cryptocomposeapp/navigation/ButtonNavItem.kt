package com.example.cryptocomposeapp.navigation

import com.example.cryptocomposeapp.R

sealed class ButtonNavItem(
    val id: Int,
    val image: Int,
    val route: String
) {
    object List : ButtonNavItem(
        R.string.nav_item_list,
        R.drawable.list_coins,
        NavigationScreens.ListScreen.route
    )

    object Favourites : ButtonNavItem(
        R.string.nav_item_fav,
        R.drawable.fav_coin,
        NavigationScreens.FavouriteScreen.route
    )
}