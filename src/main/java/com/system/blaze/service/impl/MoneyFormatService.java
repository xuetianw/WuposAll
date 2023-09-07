package com.system.blaze.service.impl;

public class MoneyFormatService {
     public static String format(double amount) {
         return String.format("%.2f", amount/100);
     }
}
