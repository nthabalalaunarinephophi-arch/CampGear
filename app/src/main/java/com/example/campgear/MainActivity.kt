package com.example.campgear

import android.annotation.SuppressLint
import android.graphics.Color.pack
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val com.example.campgear.MainActivity.it: Comparable<String>
    get() = "category"

data class Song(
    val item: String,
    val category: String,
    val qty: String,
    val comments: String
) {
    companion object {
        fun add(song: Song) {

        }
    }
}

class MainActivity : ComponentActivity() {

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var screen by remember { mutableStateOf("home") }

            var item by remember { mutableStateOf("") }
            var category by remember { mutableStateOf("") }
            var quantity by remember { mutableStateOf("") }
            var comments by remember { mutableStateOf("") }
            var gear by remember { mutableStateOf("gear") }







            Surface(
                modifier = Modifier.fillMaxSize()
            ) {

                when (screen) {


                    "home" -> {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "Welcome to camping gear app",
                                fontSize = 28.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { screen = "details" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Add gear")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { screen = "pack list" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("display list")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { finish() },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Exit")
                            }
                        }
                    }


                    "details" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Enter gear equipment items",
                                fontSize = 24.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = item,
                                onValueChange = { item = it },
                                label = { Text("item name") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = category,
                                onValueChange = { category = it },
                                label = { Text("category") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = quantity,
                                onValueChange = { quantity = it },
                                label = { Text("quantity") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = comments,
                                onValueChange = { comments = it },
                                label = { Text("Comments") }
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row {

                                Button(
                                    onClick = {


                                        val ratingValue = quantity.toIntOrNull()

                                        if (
                                            item.isNotBlank() &&
                                            category.isNotBlank() &&
                                            ratingValue != null &&
                                            ratingValue in 1..5
                                        ) {

                                            Song.add(
                                                Song(
                                                    item= item,
                                                    category = category,
                                                    qty = quantity,
                                                    comments = comments
                                                )
                                            )

                                            item = ""
                                            category = ""
                                            quantity = ""
                                            comments = ""
                                        }
                                    }
                                ) {
                                    Text("Save")
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(
                                    onClick = { screen = "home" }
                                ) {
                                    Text("Home")
                                }
                            }
                        }
                    }


                    "splash" -> {


                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {

                            Text(
                                text = "Display List",
                                fontSize = 24.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}




