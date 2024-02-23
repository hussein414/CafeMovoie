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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.cafemovoie.ui.theme.Green100

@Preview(showSystemUi = true)
@Composable
fun LoadingConnection() {
    var progressCount by remember { mutableStateOf(0) }
    val maxProgressCount = 5
    val checkBackgroundGradient = listOf(Blue300, Blue500)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bazaar_logo),
            contentDescription = null,
            modifier = Modifier.size(width = 80.dp, height = 90.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))
        CircularProgressIndicator(color = Green100)
        if (progressCount > maxProgressCount) {
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
                Image(
                    painter = painterResource(id = R.drawable.sad_face),
                    contentDescription = null
                )
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
                onClick = { progressCount = 0 }, modifier = Modifier
                    .width(100.dp)
                    .height(48.dp), colors = ButtonDefaults.buttonColors(containerColor = Blue300)
            ) {
                Text(text = "Retry", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}