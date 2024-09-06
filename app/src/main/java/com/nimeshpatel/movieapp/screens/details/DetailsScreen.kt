package com.nimeshpatel.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.nimeshpatel.movieapp.Widgets.MovieRow
import com.nimeshpatel.movieapp.model.Movie
import com.nimeshpatel.movieapp.model.findMovieById
import com.nimeshpatel.movieapp.widget.MyTopAppBar

/**
 * Created by Nimesh Patel on 05-Aug-24.
 * Purpose:
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                navController = navController,
                title = "Detail Screen",
                isBackButtonEnable = true
            )
        }
    ) {
        movieId?.let { id ->
            findMovieById(id)?.let { movie ->
                DetailContent(navController, movie = movie)
            }

        }


    }


}

@Composable
fun DetailContent(navController: NavController, movie: Movie) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            MovieRow(movie = movie)
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(text = "Movie Image")
            horizontalScrollImageView(movie)
        }

    }
}

@Composable
private fun horizontalScrollImageView(movie: Movie) {
    LazyRow {
        items(movie.images) { image ->
            val model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build()
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .width(240.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = model),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}

