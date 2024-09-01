package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        }

    }

}
@Composable
fun CreateColumn(name: String, modifier: Modifier = Modifier) {

    Column(Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally ) {
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
fun CreateRow() {

    Row(Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
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