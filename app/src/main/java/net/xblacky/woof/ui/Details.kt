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
import net.xblacky.woof.component.DogDetailBottom
import net.xblacky.woof.component.DogDetailTop
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
