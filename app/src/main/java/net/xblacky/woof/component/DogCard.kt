package net.xblacky.woof.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.woof.R
import net.xblacky.woof.data.FakeData
import net.xblacky.woof.model.Dog
import net.xblacky.woof.ui.theme.typography


@Composable
fun DogCard(dogObj: Dog) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 8.dp, 30.dp, 8.dp)
            .clip(RoundedCornerShape(18.dp)),
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
                Icon(
                    painter = painterResource(id = R.drawable.ic_heart_empty),
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(24.dp)
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