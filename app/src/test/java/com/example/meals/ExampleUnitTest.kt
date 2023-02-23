package com.example.meals

import com.example.meals.api.RetrofitHelper
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_db(){
        val instance: Retrofit = RetrofitHelper.getInstance()
    }
}