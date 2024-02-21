package com.example.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(modifier: Modifier = Modifier, navController: NavController, movieId: String?) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.LightGray
                ),
                title = {
                    Text(
                        text = "Movies",
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                        tint = Color.Black,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
            )
        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier
                    .padding(contentPadding),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieRow(movie = newMovieList.first())
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Image")
                HorizontalScrollableImageView(newMovieList)
            }
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "Movie Poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}