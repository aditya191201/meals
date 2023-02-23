package com.example.meals.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.lifecycle.ViewModelProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.meals.MealApplication
import com.example.meals.repository.MealRepository
import com.example.meals.screens.MealsCategoriesScreen
import com.example.meals.ui.theme.MealsTheme
import com.example.meals.viewmodels.MainViewModelFactory
import com.example.meals.viewmodels.MyViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            MealsTheme {
                MealsCategoriesScreen()
            }
    }
    }
    @Test
    fun myTest(){
        composeTestRule.onNodeWithContentDescription("Expand row icon 21").performClick()
        composeTestRule.onNodeWithContentDescription("Expand row icon 22").performClick()
        composeTestRule.onNodeWithText("Beef").assertExists()
        composeTestRule.onNodeWithText("Chicken").assertIsDisplayed()
    }
}