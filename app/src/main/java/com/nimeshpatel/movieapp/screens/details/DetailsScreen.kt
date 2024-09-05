package com.nimeshpatel.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.nimeshpatel.movieapp.widget.MyTopAppBar

/**
 * Created by Nimesh Patel on 05-Aug-24.
 * Purpose:
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieName: String?){
    Scaffold(
        topBar = {
            MyTopAppBar(navController=navController, title = "Detail Screen" , isBackButtonEnable = true)
        }
    ) {
        DetailContent(navController,movieName = movieName)
    }
    

}

@Composable
fun DetailContent(navController: NavController, movieName: String?){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$movieName", style = MaterialTheme.typography.headlineLarge)
        }

    }
}