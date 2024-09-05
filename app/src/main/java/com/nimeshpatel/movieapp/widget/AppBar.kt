package com.nimeshpatel.movieapp.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Created by Nimesh Patel on 05-Aug-24.
 * Purpose:
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    navController: NavController,
    title: String,
    isBackButtonEnable: Boolean = false,
) {
    Surface(
        shadowElevation = 4.dp,
        tonalElevation = 4.dp,
    ) {
        TopAppBar(
            title = {
                Row {
                    if (isBackButtonEnable) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Arrow",
                            modifier =
                                Modifier.clickable {
                                    navController.popBackStack()
                                },
                        )
                        Spacer(modifier = Modifier.width(100.dp))
                    }
                    Text(text = title)
                }
            },
            colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
        )
    }
}
