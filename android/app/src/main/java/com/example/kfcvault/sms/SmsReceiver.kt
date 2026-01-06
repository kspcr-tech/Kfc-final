package com.example.kfcvault.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        for (msg in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
            SmsParser.parse(msg.messageBody)
        }
    }
}
