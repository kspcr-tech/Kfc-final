package com.example.kfcvault.model

data class GiftCard(
    val id: Long = System.currentTimeMillis(),
    val cardNumber: String,
    val pin: String,
    val balance: String = "--",
    val expiry: String = "--",
    val redeemed: Boolean = false
)
