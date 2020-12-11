package com.example.mycompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.MyComposeTheme

class MainActivity : AppCompatActivity() {

    var people = mutableListOf<String>()

    var mynumber = mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        people.add("Arne")
        people.add("Bengt")
        people.add("Caesar")
        people.add("David")


        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Greeting("Android YY")
                        Greeting("Android AA")
                        Greeting("Android BB")

                        Spacer(modifier = Modifier.preferredHeight(30.dp))

                        Text(mynumber.value.toString())
                        
                        Button(onClick = {
                            mynumber.value = mynumber.value + 1
                            people.add("Torsten")
                        }) {
                            Text("Tryck här!")
                        }
                        
                        Spacer(modifier = Modifier.preferredHeight(30.dp))

                        if(mynumber.value > 5)
                        {
                            Image(imageResource(id = R.drawable.frog), modifier = Modifier.preferredSize(150.dp, 150.dp).clip(shape = CircleShape).padding(20.dp))
                        }

                        Row {
                            FancyBox(titletext = "ETT")
                            FancyBox(titletext = "TVÅ")
                            FancyBox(titletext = "TRE")

                        }

                        LazyColumnFor(items = people, modifier = Modifier.preferredHeight(250.dp)) { person ->
                            Text(person)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun FancyBox(titletext: String) {
    Column {
        Text(text = "$titletext!")

        var imgMod = Modifier.preferredSize(100.dp, 100.dp).padding(10.dp)
        Image(imageResource(id = R.drawable.frog), modifier = imgMod)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Column {
            Greeting("Android YY")
            Greeting("Android AA")
            Greeting("Android BB")

            Image(imageResource(id = R.drawable.frog), modifier = Modifier.preferredSize(50.dp, 50.dp).clip(shape = CircleShape))
        }

    }
}