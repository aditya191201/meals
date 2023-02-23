package com.example.meals.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras

import com.example.meals.MealApplication
import com.example.meals.models.MealResponse
import com.example.meals.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class MyViewModel(
    private val myRepository: MealRepository
) : ViewModel() {


    val mealState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())
init {
    viewModelScope.launch(Dispatchers.IO){
        val meals = getMeals()
        if(meals!=null){
            mealState.value = meals
        }else{
            mealState.value = emptyList()
        }
    }
}

private suspend fun getMeals(): List<MealResponse>? {
    return myRepository.getMeals()
}
}

