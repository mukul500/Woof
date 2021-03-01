package net.xblacky.woof.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.R


@Preview
@Composable
fun TopBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 8.dp, 30.dp, 8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Hey xBlacky",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.surface
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Adopt a new friend",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.surface
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 24.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            WoofDarkMode()
        }


    }
}

@Composable
fun WoofDarkMode() {
    val icon = painterResource(id = R.drawable.ic_sun)

    Icon(
        painter = icon,
        contentDescription = null,
        modifier = Modifier.size(24.dp, 24.dp)
    )
}