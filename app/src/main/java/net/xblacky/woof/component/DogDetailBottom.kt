package net.xblacky.woof.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.woof.R
import net.xblacky.woof.model.Dog
import net.xblacky.woof.ui.theme.typography

@Composable
fun DogDetailBottom(dogObj: Dog) {

    Column(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = dogObj.largeImage),
                contentDescription = "",
                modifier = Modifier
                    .size(340.dp)
            )
        }

        Text(
            text = "About",
            color = MaterialTheme.colors.surface,
            fontWeight = FontWeight.Bold,
            style = typography.h4,
            modifier = Modifier.padding(24.dp, 4.dp, 4.dp, 24.dp)
        )

        Text(
            text = dogObj.about,
            color = MaterialTheme.colors.surface,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(24.dp, 4.dp, 24.dp, 0.dp),
            style = TextStyle(fontSize = 14.sp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Card(
                modifier = Modifier
                    .padding(30.dp, 16.dp, 0.dp, 0.dp)
                    .clip(RoundedCornerShape(60.dp, 0.dp, 0.dp, 0.dp))
                    .size(220.dp, 60.dp),
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Row(
                    modifier = Modifier.padding(60.dp, 8.dp, 30.dp, 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_paw),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colors.background
                    )

                    Spacer(modifier = Modifier.size(18.dp))
                    Text(
                        text = "Adopt Me",
                        color = MaterialTheme.colors.background,
                        fontWeight = FontWeight.Bold,
                        style = typography.subtitle2
                    )
                }

            }
        }


    }

}