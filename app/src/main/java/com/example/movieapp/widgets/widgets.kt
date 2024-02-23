package com.example.movieapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

//@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Column(modifier = Modifier.size(height = 300.dp, width = 170.dp)) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .clickable { onItemClick(movie.id) },
            shape = RoundedCornerShape(corner = CornerSize(0.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Surface {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = movie.poster)
                            .build(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                            .height(250.dp),
                        contentDescription = "Movie Poster"
                    )
                }
            }
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 5.dp)
            )
            Text(
                text = "Rating: ${movie.rating}",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}
@Composable
fun MovieNew(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Column(modifier = Modifier.size(height = 300.dp, width = 170.dp)) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .clickable { onItemClick(movie.id) },
            shape = RoundedCornerShape(corner = CornerSize(0.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Surface {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = movie.poster)
                            .build(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                            .height(250.dp),
                        contentDescription = "Movie Poster"
                    )
                }
            }
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 5.dp)
            )
            Text(
                text = "Rating: ${movie.rating}",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}
//@Preview
@Composable
fun MoviePopular(movie: Movie = getMovies()[0]) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(height = 200.dp, width = 300.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = movie.poster)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            contentDescription = "Movie Poster"
        )
    }
}