package com.example.meals.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.meals.models.MealResponse
import com.example.meals.viewmodels.MyViewModel

@Composable
fun MealsCategoriesScreen() {
    val meal1 = MealResponse("21","Beef",
        "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]",
        "https://www.themealdb.com/images/category/beef.png")
    val meal2 = MealResponse("22","Chicken","Chicken is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011.[1] Humans commonly keep chickens as a source of food (consuming both their meat and eggs) and, more rarely, as pets.","https://www.themealdb.com/images/category/chicken.png")
    val meal3 = MealResponse("23","Dessert","Dessert is a course that concludes a meal. The course usually consists of sweet foods, such as confections dishes or fruit, and possibly a beverage such as dessert wine or liqueur, however in the United States it may include coffee, cheeses, nuts, or other savory items regarded as a separate course elsewhere. In some parts of the world, such as much of central and western Africa, and most parts of China, there is no tradition of a dessert course to conclude a meal.\n" +
            "\n" +
            "The term dessert can apply to many confections, such as biscuits, cakes, cookies, custards, gelatins, ice creams, pastries, pies, puddings, and sweet soups, and tarts. Fruit is also commonly found in dessert courses because of its naturally occurring sweetness. Some cultures sweeten foods that are more commonly savory to create desserts.","https://www.themealdb.com/images/category/dessert.png")

//    val meals = mainViewModel.mealState.value
//    if(meals.isEmpty()){
//        Text("error")
//    }else{
//        LazyColumn(contentPadding = PaddingValues(16.dp)){
//            items(meals){meal->
//                MealCategory(meal = meal)
//            }
//        }
//    }
    val list = mutableListOf<MealResponse>()
    list.add(meal1)
    list.add(meal2)
    list.add(meal3)
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(list){meal->
            MealCategory(meal = meal)
        }
    }
}

@Composable
fun MealCategory(meal: MealResponse) {
    var isExpanded by remember{ mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)

    ) {
        Row(modifier = Modifier.animateContentSize()) {
            //Image
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
                    .testTag("icon_image")
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
            ) {
                Text(text = meal.name, style = MaterialTheme.typography.h6, modifier = Modifier.testTag("meal_name"))
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = meal.description,
                        textAlign  = TextAlign.Start,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if(isExpanded) 10 else 4,
                        modifier = Modifier.testTag("meal_desc")
                    )
                }
            }
            Icon(imageVector = if(isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand row icon ${meal.id}",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { isExpanded = !isExpanded })
        }
    }

}