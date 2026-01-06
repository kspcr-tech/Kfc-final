
package com.example.kfcvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var cards by remember { mutableStateOf(listOf("**** **** 1234")) }
                Scaffold(
                    topBar = { TopAppBar(title = { Text("KFC Gift Card Vault") }) },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            cards = cards + "**** **** ${(1000..9999).random()}"
                        }) { Text("+") }
                    }
                ) { innerPadding ->
                    LazyColumn(Modifier.padding(innerPadding).fillMaxSize()) {
                        items(cards.size) { idx ->
                            Card(Modifier.padding(12.dp)) {
                                Column(Modifier.padding(16.dp)) {
                                    Text("Card: ${'$'}{cards[idx]}")
                                    Text("Balance: ₹--")
                                    Text("Expiry: --")
                                    Button(onClick = {}) { Text("Refresh") }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
