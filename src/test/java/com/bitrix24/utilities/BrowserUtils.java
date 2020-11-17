package com.bitrix24.utilities;

public class BrowserUtils {

    public static void waitFor(int seconds) {

        try{

            Thread.sleep(seconds * 1000);
            //because sleep methods accepts only milliseconds

        }catch (InterruptedException e){

            e.printStackTrace();
        }

    }





}
