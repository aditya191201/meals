package com.example.meals.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.meals.models.MealResponse
import com.google.common.truth.Truth
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MealDatabaseTest : TestCase(){
    private lateinit var db: MealDatabase
    private lateinit var dao: MealsDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MealDatabase::class.java).allowMainThreadQueries().build()
        dao = db.mealDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun mealDatabaseTest() = runBlocking {

        val meal = MealResponse("20","Aditya", "Deshpande","image1")
        val meals = mutableListOf<MealResponse>()
        meals.add(meal)
        dao.addMeals(meals)
        val meals1 = dao.getMeals()
        Truth.assertThat(meals1.contains(meal)).isTrue()
    }


}