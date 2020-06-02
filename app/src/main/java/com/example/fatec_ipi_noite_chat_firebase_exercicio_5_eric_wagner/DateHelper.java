package com.example.fatec_ipi_noite_chat_firebase_exercicio_5_eric_wagner;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateHelper {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public static String format(Date date) {
        return sdf.format(date);
    }
}
