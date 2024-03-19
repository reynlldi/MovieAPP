package com.example.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = "Detail Movie",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.clickable {
                            navController.navigateUp()
                        }
                    )
                }
            )
        }
    ) { contentPadding ->
        Column(modifier.padding(contentPadding)) {
            Text(text = "Ini Halaman Notifikasi")
        }
    }
}