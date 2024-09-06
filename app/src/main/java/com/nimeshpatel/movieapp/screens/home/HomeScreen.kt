package com.nimeshpatel.movieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nimeshpatel.movieapp.R
import com.nimeshpatel.movieapp.Widgets.MovieRow
import com.nimeshpatel.movieapp.model.Movie
import com.nimeshpatel.movieapp.model.getMovies
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
    paddingValues: PaddingValues, navController: NavController, movieList: List<Movie> = getMovies()
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
