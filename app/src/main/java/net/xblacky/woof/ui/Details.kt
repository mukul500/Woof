package net.xblacky.woof.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.xblacky.woof.component.*
import net.xblacky.woof.data.FakeData

@Composable
fun Details(navController: NavController, id: Int) {
    val dogObj = FakeData.dogList[id]
    Surface(color = MaterialTheme.colors.primaryVariant) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            item {
                DogDetailTop(dogObj = dogObj)
            }
            item {
                DogDetailBottom(dogObj = dogObj)
            }

        }
    }
}