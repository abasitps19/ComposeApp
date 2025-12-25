package com.iot.composeapp.presentation.lists.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(16.dp),

        colors = CardDefaults.cardColors(Color.Yellow),
        elevation = CardDefaults.cardElevation(8.dp)

    ) {
        Text(
            text = "This is a simple card",
            modifier = Modifier.padding(16.dp)
        )

    }
}