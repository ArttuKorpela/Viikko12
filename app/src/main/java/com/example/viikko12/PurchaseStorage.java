package com.example.viikko12;

import java.util.ArrayList;

public class PurchaseStorage {

    private static PurchaseStorage single_instance = null;
    ArrayList<Purchase> currentPurchases = new ArrayList<>();


    private PurchaseStorage(){}

    public static synchronized PurchaseStorage getInstance() {
        if (single_instance == null){
            single_instance = new PurchaseStorage();
        }

        return single_instance;
    }

    public void addPurchase(Purchase newLutemon){

        currentPurchases.add(newLutemon);
    }

    public ArrayList<Purchase> getCurrentLutemons() {
        return currentPurchases;
    }
}
