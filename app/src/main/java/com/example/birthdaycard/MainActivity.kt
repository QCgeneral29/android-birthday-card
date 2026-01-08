package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Allow navigation bar to be transparent
        // TODO continue tutorial:
        // https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%3F_gl%3D1*1034hmd*_up*MQ..*_ga*NzY5NDU5OTkxLjE3Njc4NDc2NTg.*_ga_6HH9YJMN9M*czE3Njc4NDc2NTckbzEkZzAkdDE3Njc4NDc2NTckajYwJGwwJGgyMTMwMzU3MTAw%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-images&_gl=1*1034hmd*_up*MQ..*_ga*NzY5NDU5OTkxLjE3Njc4NDc2NTg.*_ga_6HH9YJMN9M*czE3Njc4NDc2NTckbzEkZzAkdDE3Njc4NDc2NTckajYwJGwwJGgyMTMwMzU3MTAw#4
        window.setNavigationBarContrastEnforced(false)
        setContent {
            BirthdayCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday Landen!",
                        from = "From Brandi"
                    )
                }

            }
        }
    }
}

@Composable
fun GreetingText(message : String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        //GreetingText(message = "Happy Birthday Landen!", from = "From Brandi")
        GreetingImage(
            message = "Happy Birthday Landen!",
            from = "From Brandi"
        )
    }
}
