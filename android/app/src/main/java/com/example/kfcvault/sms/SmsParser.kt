package com.example.kfcvault.sms

import com.example.kfcvault.storage.GiftCardStore

object SmsParser {
    fun parse(text: String) {
        if (!text.contains("KFC", true)) return

        val balance = Regex("Rs.?\\s?(\\d+)").find(text)?.groupValues?.get(1) ?: "--"
        val expiry = Regex("(\\d{2}/\\d{2}/\\d{4})").find(text)?.value ?: "--"

        GiftCardStore.cards.firstOrNull()?.let {
            GiftCardStore.update(it.copy(balance = balance, expiry = expiry))
        }
    }
}
