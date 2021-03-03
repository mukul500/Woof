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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.woof.R
import net.xblacky.woof.model.Dog
import net.xblacky.woof.ui.theme.typography

@Composable
fun DogDetailTop(dogObj: Dog) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 36.dp, 24.dp, 0.dp),
    ) {
        Column {
            Text(
                text = dogObj.name,
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Bold,
                style = typography.h4
            )
            Text(
                text = dogObj.breed,
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp),
                style = TextStyle(fontSize = 14.sp)
            )
            DogLocation(location = dogObj.location)
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            val drawable =
                if (dogObj.gender == "Male") painterResource(id = R.drawable.ic_male) else painterResource(
                    id = R.drawable.ic_female
                )
            Icon(
                painter = drawable,
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.primary
            )
            Text(
                text = buildString {
                    append("${dogObj.gender}, ")
                        .append("${dogObj.age} Year Old")
                },
                modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
                color = MaterialTheme.colors.surface,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}
