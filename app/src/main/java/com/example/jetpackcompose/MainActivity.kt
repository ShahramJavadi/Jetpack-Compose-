package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme {
                InitUi()
            }
        }
    }
}

@Composable
fun InitUi() {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column {
            CreateColumn(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
            CreateRow()
            CreateText()
            Spacer(modifier = Modifier.height(10.dp))
            CreateSpannableText()
        }

    }

}

@Composable
fun CreateColumn(name: String, modifier: Modifier = Modifier) {

    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Text 1",
            modifier = modifier
        )

        Text(
            text = "Text 2",
            modifier = modifier
        )

    }

}

@Composable
fun CreateText() {


    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue),
        color = Color.Cyan,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        text = "Testing Text",
        textDecoration = TextDecoration.LineThrough

    )
}

@Composable
fun CreateSpannableText() {


    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        color = Color.Cyan,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = Color.Yellow,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )){
                append("T")
            }
            withStyle(style = SpanStyle(
                color = Color.Red,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )){
                append("est")
            }
        },

    )
}

@Composable
fun CreateRow() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Text 1",
        )

        Text(
            text = "Text 2",
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTheme {
        InitUi()
    }
}