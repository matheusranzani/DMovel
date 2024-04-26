package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Composable1() {
    var counter = 0;
    var counter2 by rememberSaveable {
        mutableStateOf(0);
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyButton(
            label = "Click Me",
            onClicked = {
                counter++;
                Log.i("Composable1", "Counter: " + counter);
                counter2++;
            }
        )

        MyButton("Enable / Disable");

        Text(text = "You clicked " + counter2 + " times!");
    }
}