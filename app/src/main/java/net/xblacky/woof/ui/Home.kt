package net.xblacky.woof.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import net.xblacky.woof.component.DogCard
import net.xblacky.woof.component.TopBar
import net.xblacky.woof.model.Dog


@Composable
fun Home(navController: NavController, dogList: List<Dog>) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            item {
                TopBar()
            }
            dogList.forEach {
                item {
                    DogCard(dogObj = it, onItemClicked = {
                        navController.navigate("details/${it.id}/")
                    })
                }

            }

        }
    }
}