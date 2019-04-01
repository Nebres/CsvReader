package com.reader.Csv_Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    private String tempData;

    public boolean initTempData(String path) throws IOException {

        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String output = "";
        StringBuilder builder = new StringBuilder(output);
        String temp;

        try {
            do {
                temp = reader.readLine();
                builder.append(temp);
            } while (temp != null);
            output = builder.toString();
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            reader.close();
        }
        setTempData(output);
        return !output.equals("");
    }

    private void setTempData(String tempData) {
        this.tempData = tempData;
    }

    public String getTempData() {
        return tempData;
    }

    public String[] buildArray(String textToChange) {
        String temp = textToChange.replace("\"", "");
        return temp.split(";");
    }

}
