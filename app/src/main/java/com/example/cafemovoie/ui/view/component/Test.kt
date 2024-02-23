package com.example.cafemovoie.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafemovoie.R
import com.example.cafemovoie.ui.theme.Blue100
import com.example.cafemovoie.ui.theme.Blue300
import com.example.cafemovoie.ui.theme.Blue500
import com.example.cafemovoie.ui.theme.Blue700

@Preview(showBackground = true)
@Composable
fun Test() {
    val checkBackgroundGradient = listOf(Blue300, Blue500, Blue700)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = checkBackgroundGradient,
                        startY = 0.5f,
                    ), shape = RoundedCornerShape(48.dp)
                )
                .clip(CircleShape), contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.sad_face), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Connection glitch",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Seems like there's an internet\n" +
                    "connection problem.",
            color = Blue100,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .width(100.dp)
                .height(48.dp), colors = ButtonDefaults.buttonColors(containerColor = Blue300)
        ) {
            Text(text = "Retry", color = Color.White, fontSize = 14.sp)
        }

    }
}