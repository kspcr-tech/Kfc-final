package com.example.kfcvault.storage

import androidx.compose.runtime.mutableStateListOf
import com.example.kfcvault.model.GiftCard

object GiftCardStore {
    val cards = mutableStateListOf<GiftCard>()

    fun add(card: GiftCard) = cards.add(card)

    fun update(updated: GiftCard) {
        val i = cards.indexOfFirst { it.id == updated.id }
        if (i >= 0) cards[i] = updated
    }

    fun active() = cards.filter { !it.redeemed }
    fun archived() = cards.filter { it.redeemed }
}
