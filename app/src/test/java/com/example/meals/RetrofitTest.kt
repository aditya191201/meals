package com.example.meals

import com.example.meals.api.MealService
import com.example.meals.api.RetrofitHelper
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTest {
    @Test
    fun testRetrofitInstance(){
        val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
        val instance: Retrofit = RetrofitHelper.getInstance()
        assert(instance.baseUrl().toString() == baseUrl)
    }
    lateinit var mockWebServer: MockWebServer
    lateinit var mealsApi: MealService

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        mealsApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MealService::class.java)
    }

    @Test
    fun testGetMeals() = runTest{
        val mockResponse = MockResponse()
        val content = Helpers.readFileResources("/response.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)

        val response =  mealsApi.getMeals()
        mockWebServer.takeRequest()
        Assert.assertEquals(false, response.categories.isEmpty())
        Assert.assertEquals(3, response.categories.size)
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}