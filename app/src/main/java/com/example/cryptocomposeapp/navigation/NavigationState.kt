package com.example.cryptocomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Класс, котрый управляет всей навигацией
class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            // Функция убирает из backStack все экраны между последниим открытым и стартовым
            // findStartDestination().id - определяет стартовый экран в грфае навигации
            // (обязательное использование при вложенном графе)
            popUpTo(navHostController.graph.findStartDestination().id) {
                // Сохранение состояния у удаленного экрана
                saveState = true
            }
            // Создается один объект экрана в backStack,
            // при нескольких нажатях на один item в bottomNavigation, новый экземпляр создаваться не будет
            launchSingleTop = true
            // Восстановление состояния у удаленного экрана при переходе на него
            restoreState = true
        }
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}