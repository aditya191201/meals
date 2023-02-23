package com.example.meals.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.meals.models.MealResponse


@Database(entities = [MealResponse::class], version = 1, exportSchema = false)
abstract class MealDatabase : RoomDatabase() {
    abstract fun mealDao() : MealsDao

    companion object{
        @Volatile
        private var INSTANCE: MealDatabase?  = null

        fun getDatabase(context: Context): MealDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        MealDatabase::class.java,
                    "meal_db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}
