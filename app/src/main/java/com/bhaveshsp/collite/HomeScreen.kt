package com.bhaveshsp.collite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhaveshsp.collite.ui.theme.ColliteTheme
import com.bhaveshsp.collite.ui.theme.PrimaryColor
import com.bhaveshsp.collite.ui.theme.SearchBackgroundColor

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeIcon = painterResource(id = R.drawable.theme_icon)
            val contentDes = "Changes theme of the App"
            val searchIcon = painterResource(id = R.drawable.search_icon)
            ColliteTheme {
                HomeScreen("Collite",themeIcon,contentDes,searchIcon)
            }
        }
    }
}

@Composable
fun HomeScreen(
    name: String,
    themeIcon: Painter,
    contentDes : String,
    searchIcon : Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.White)){
        HomeScreenTopBar(name = name, themeIcon = themeIcon, contentDes = contentDes)
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
        SearchBar(searchIcon = searchIcon, searchDes = contentDes)
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchIcon : Painter,
    searchDes : String
){
    TextField(value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text(text = "Search",color = PrimaryColor)},
        leadingIcon = { Icon(painter = searchIcon, contentDescription = searchDes)},
        shape = RoundedCornerShape(16.dp)
    )
}


@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    name: String,
    themeIcon: Painter,
    contentDes: String
){
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
    ){
        Text(text = name,
            style = TextStyle(
                color = PrimaryColor,
                fontSize = 32.sp
            ),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Image(painter = themeIcon,
            contentDescription =  contentDes,
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val themeIcon = painterResource(id = R.drawable.theme_icon)
    val contentDes = "Changes theme of the App"
    val searchIcon = painterResource(id = R.drawable.search_icon)

    ColliteTheme {
        HomeScreen("Collite",themeIcon,contentDes,searchIcon)
    }
}