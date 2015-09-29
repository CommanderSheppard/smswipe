package com.datasorcerers.smswipe.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSMonitor extends BroadcastReceiver {
    private SmsMessage[] messages;
    private String body = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        String address = "";
        StringBuilder fullMessage = new StringBuilder();
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] pduArray = (Object[]) intentExtras.get("pdus");
            messages = new SmsMessage[pduArray.length];
            for (int i = 0; i < pduArray.length; ++i) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pduArray[i]);
                fullMessage.append(messages[i].getMessageBody());
                //         address = messages[0].getOriginatingAddress();
            }
            body = fullMessage.toString() + '\n' + "SENT FROM: " + address;
            System.out.println(body);
        }
    }
}