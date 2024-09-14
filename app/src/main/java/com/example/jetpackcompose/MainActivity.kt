package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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

    Surface(modifier = Modifier.fillMaxSize()) { ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CreateTopAppBarView()

            Spacer(modifier = Modifier.height(16.dp))
            GenerateShape(shape = CircleShape, size = 90.dp, color = Color.Red)
            Spacer(modifier = Modifier.height(16.dp))

            GenerateShape(shape = RoundedCornerShape(16.dp, 16.dp), size = 90.dp, color = Color.Red)
            Spacer(modifier = Modifier.height(16.dp))

            GenerateShape(shape = CutCornerShape(16.dp, 16.dp), size = 90.dp, color = Color.Red)
            Spacer(modifier = Modifier.height(16.dp))

            CreateCircleImage(
                painter = painterResource(id = R.drawable.nature),
                size = 110.dp,
                borderWidth = 2.dp,
                borderColor = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))

            CreateTextField()
//            CreateColumn(
//                name = "Android",
//                modifier = Modifier.padding(innerPadding)
//            )
//            CreateRow()
//            CreateText()
//            Spacer(modifier = Modifier.height(10.dp))
//            CreateSpannableText()
//            CreateCounterButton()
        }

    }

}

@Composable
fun CreateListItem(
    painter: Painter,
    title: String,
    description: String,
    price: String,
    discountedPrice: String
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Box {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(

                        Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black))

                    ),
            ) {}

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp), contentAlignment = Alignment.BottomCenter
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(text = title, color = Color.White)
                        Text(text = discountedPrice, color = Color.White)

                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = description, color = Color.White)
                        Text(
                            text = price,
                            color = Color.White,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }
            }

        }


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTopAppBarView() {


    TopAppBar(colors = TopAppBarColors(
        containerColor = Color.Red,
        scrolledContainerColor = Color.Red,
        navigationIconContentColor = Color.Red,
        actionIconContentColor = Color.Red,
        titleContentColor = Color.Black), title = {

        Text(text = "AppBar")
    },
        modifier = Modifier.background(Color.Black),
        actions = {

            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }

            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }


        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        })


}

@Composable
fun CreateTextField() {

    var textState by remember {

        mutableStateOf(TextFieldValue("Jetpack Compose"))
    }

    TextField(value = textState, onValueChange = { textState = it })

}

@Composable
fun CreateCircleImage(painter: Painter, size: Dp, borderWidth: Dp, borderColor: Color) {


    Image(
        painter = painter, contentDescription = null, modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .border(borderWidth, borderColor, CircleShape),
        contentScale = ContentScale.FillBounds
    )


}


@Composable
fun GenerateShape(shape: Shape, size: Dp, color: Color) {

    Box(
        modifier = Modifier
            .clip(shape)
            .size(size)
            .background(color)
    )
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

var counterState = mutableStateOf(0)

@Composable
fun CreateCounterButton() {

    var counter by remember {
        counterState
    }
    Column {
        Button(onClick = { counter++ }) {

            Text(text = "Increase")

        }

        Text(text = counter.toString())


    }


}

@Composable
fun CreateText() {


    Text(
        modifier = Modifier
            .background(Color.Blue)
            .border(3.dp, Color.Black)
            .padding(16.dp)
            .clickable {
                Log.d("Jetpack Compose", "CreateText: ")
            },
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
            withStyle(
                style = SpanStyle(
                    color = Color.Yellow,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("T")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
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