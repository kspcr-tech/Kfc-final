package com.example.kfcvault.ai

import com.example.kfcvault.sms.SmsParser

object TextParser {
    fun parsePastedText(text: String) {
        // Phase-1: heuristic parsing
        SmsParser.parse(text)
    }
}
