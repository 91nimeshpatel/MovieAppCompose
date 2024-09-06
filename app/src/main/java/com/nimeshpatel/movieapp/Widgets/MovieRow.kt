package com.nimeshpatel.movieapp.Widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nimeshpatel.movieapp.R
import com.nimeshpatel.movieapp.model.Movie
import com.nimeshpatel.movieapp.model.getMovies

/**
 * Created by Nimesh Patel on 06-Sep-24.
 * Purpose:
 */

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies().first(), onItemClick: (String) -> Unit = {}) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
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
                shape = CircleShape,
                shadowElevation = 4.dp
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images.first())
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )

            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "Director: ${movie.director}",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Release: ${movie.year}",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )

                AnimatedVisibility(visible = isExpanded) {
                    Column{
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.DarkGray,
                                    fontSize = 13.sp)
                                ){
                                    append("Plot: ")
                                }
                                withStyle(style = SpanStyle(color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light
                                )
                                ){
                                    append(movie.plot)
                                }
                            },
                            modifier = Modifier.padding(6.dp)
                        )
                        Divider()
                        Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            isExpanded = !isExpanded
                        },
                    tint = Color.DarkGray
                )
            }
        }

    }
}