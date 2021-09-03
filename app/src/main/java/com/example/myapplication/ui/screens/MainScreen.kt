package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.UserVM
import javax.inject.Inject

@Composable
fun MainScreen(
    viewModel: UserVM
) {
    val stringies by viewModel.strings.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            stringies.forEach {
                Text(text = it.name)
            }
        }
        Button(
            onClick = {
                viewModel.fetch()
            }
        ) {
            Text(text = "fetchData")
        }
        Button(
            onClick = {
                viewModel.save()
            }
        ) {
            Text(text = "save")
        }
        Button(
            onClick = {
                viewModel.read()
            }
        ) {
            Text(text = "getData")
        }
        Button(
            onClick = {
                viewModel.reset()
            }
        ) {
            Text(text = "reset field")
        }
    }
}