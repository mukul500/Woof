package net.xblacky.woof.component

import androidx.compose.foundation.layout.*
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
            .padding(24.dp),
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