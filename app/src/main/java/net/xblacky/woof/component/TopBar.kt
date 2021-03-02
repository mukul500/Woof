package net.xblacky.woof.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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

    }
}
