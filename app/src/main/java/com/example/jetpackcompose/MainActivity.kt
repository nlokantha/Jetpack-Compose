package com.example.jetpackcompose

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }
    }
}
data class User(
    val id:Int
)
val users = mutableListOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
)

@Composable
fun UserList(){
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        for (i in 1..10){
//            UserCard()
//        }
//    }
    LazyColumn{
        items(users){user ->
            UserCard()
        }
    }
}
@Composable
fun UserCard() {
    Card (modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .wrapContentHeight()
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .padding(12.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.shopping_cart),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Lokantha Namal",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(12.dp))
                Button(onClick = { }) {
                    Text(text = "View Profile")
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        UserList()
    }
}