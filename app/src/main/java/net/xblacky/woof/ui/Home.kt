/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
                    DogCard(
                        dogObj = it,
                        onItemClicked = {
                            navController.navigate("details/${it.id}/")
                        }
                    )
                }
            }
        }
    }
}
