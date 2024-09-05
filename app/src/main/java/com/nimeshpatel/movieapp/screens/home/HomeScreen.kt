package com.nimeshpatel.movieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nimeshpatel.movieapp.navigation.MovieScreens
import com.nimeshpatel.movieapp.widget.MyTopAppBar

/**
 * Created by Nimesh Patel on 05-Aug-24.
 * Purpose:
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyTopAppBar(navController = navController, title = "Home")
        },
    ) {
        MainContent(PaddingValues(top = 50.dp), navController = navController)
    }
}


@Composable
fun MainContent(
    paddingValues: PaddingValues, navController: NavController, movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Porter",
        "Happiness...",
        "Cross the Line...",
        "Be..",
        "Happy..",
        "Life"
    )
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(movieList.size) { index ->
                    MovieRow(movieList[index]) { movie ->
                        Log.e("neem", "Item Click : $movie")
                        navController.navigate(route = MovieScreens.DetailScreen.name + "/$movie")
                    }
                }
            }
        }

    }
}

@Composable
private fun MovieRow(movieName: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movieName)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")

            }
            Text(text = movieName, color = Color.Black)
        }

    }
}
