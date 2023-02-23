package com.example.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.example.meals.screens.MealsCategoriesScreen
import com.example.meals.ui.theme.MealsTheme
import com.example.meals.viewmodels.MainViewModelFactory
import com.example.meals.viewmodels.MyViewModel


class MainActivity : ComponentActivity() {

    lateinit var mainViewModel: MyViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository  = (application as MealApplication).mealRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MyViewModel::class.java)
        setContent {
            MealsTheme {

                MealsCategoriesScreen()
            }
        }
    }

}


