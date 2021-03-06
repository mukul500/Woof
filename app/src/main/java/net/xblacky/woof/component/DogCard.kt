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
package net.xblacky.woof.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.woof.R
import net.xblacky.woof.model.Dog
import net.xblacky.woof.ui.theme.typography

@Composable
fun DogCard(dogObj: Dog, onItemClicked: (dog: Dog) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 8.dp, 30.dp, 8.dp)
            .clip(RoundedCornerShape(18.dp))
            .clickable(onClick = { onItemClicked(dogObj) }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            val image: Painter = painterResource(id = dogObj.smallImage)
            Image(
                painter = image,
                contentDescription = "",
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .clip(RoundedCornerShape(18.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                DogName(dogName = dogObj.name)
                DogBreed(breed = dogObj.breed)

                Text(
                    text = buildString {
                        append("${dogObj.gender}, ")
                            .append("${dogObj.age} Year Old")
                    },
                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    style = TextStyle(fontSize = 10.sp)
                )

                DogLocation(location = dogObj.location)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 8.dp, 0.dp),
                horizontalAlignment = Alignment.End
            ) {
                val favouriteState = remember { mutableStateOf(false) }
                val drawable =
                    if (favouriteState.value) painterResource(id = R.drawable.ic_heart_fill) else painterResource(
                        id = R.drawable.ic_heart_empty
                    )
                Icon(
                    painter = drawable,
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            onClick = {
                                favouriteState.value = !favouriteState.value
                            }
                        )
                )
            }
        }
    }
}

@Composable
fun DogName(dogName: String) {
    Text(
        text = dogName,
        color = MaterialTheme.colors.surface,
        fontWeight = FontWeight.Bold,
        style = typography.subtitle1
    )
}

@Composable
fun DogBreed(breed: String) {
    Text(
        text = breed,
        color = MaterialTheme.colors.surface,
        fontWeight = FontWeight.Light,
        modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp),
        style = TextStyle(fontSize = 10.sp)
    )
}

@Composable
fun DogLocation(location: String) {
    Row(
        modifier = Modifier.padding(0.dp, 18.dp, 0.dp, 0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_locatioin),
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = location,
            style = TextStyle(fontSize = 10.sp),
            color = MaterialTheme.colors.surface,
            textAlign = TextAlign.Center

        )
    }
}
