package com.example.dell.currencyconverter;

import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Gson gson = new Gson();
        ThemeObject themeObject = new ThemeObject();
        themeObject.setColor("adasdas");
        themeObject.setNameColor("Quang");
        String jsonInString = gson.toJson(themeObject);

    }
}