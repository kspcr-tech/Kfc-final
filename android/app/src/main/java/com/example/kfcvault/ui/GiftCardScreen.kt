package com.example.kfcvault.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kfcvault.model.GiftCard
import com.example.kfcvault.storage.GiftCardStore

@Composable
fun GiftCardScreen() {
    var showPin by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().padding(12.dp)) {

        Button(onClick = {
            GiftCardStore.add(
                GiftCard(
                    cardNumber = "XXXX-XXXX-1234",
                    pin = "1234"
                )
            )
        }) { Text("Add Gift Card") }

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(GiftCardStore.active().size) { i ->
                val card = GiftCardStore.active()[i]

                Card(Modifier.padding(8.dp)) {
                    Column(Modifier.padding(12.dp)) {
                        Text("Card: ${card.cardNumber}")
                        Text("Balance: ₹${card.balance}")
                        Text("Expiry: ${card.expiry}")

                        Row {
                            Text(
                                "PIN: " + if (showPin) card.pin else "****"
                            )
                            IconButton(onClick = { showPin = !showPin }) {
                                Icon(
                                    if (showPin) Icons.Default.VisibilityOff
                                    else Icons.Default.Visibility,
                                    contentDescription = null
                                )
                            }
                        }

                        Row {
                            Button(onClick = { /* SMS refresh */ }) {
                                Text("Refresh")
                            }
                            Spacer(Modifier.width(8.dp))
                            Button(onClick = {
                                GiftCardStore.update(card.copy(redeemed = true))
                            }) {
                                Text("Redeemed")
                            }
                        }
                    }
                }
            }
        }
    }
}
