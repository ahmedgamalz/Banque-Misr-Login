package com.example.banquemisrlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomService(serviceName: String, serviceImage: Int, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
    ) {
        Image(
            modifier = modifier.size(72.dp),
            painter = painterResource(id = serviceImage),
            contentDescription = serviceName
        )
        Text(
            text = serviceName,
            fontSize = 10.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.size(72.dp)

        )
    }
}