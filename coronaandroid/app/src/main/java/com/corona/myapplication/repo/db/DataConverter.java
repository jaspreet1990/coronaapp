package com.corona.myapplication.repo.db;

import androidx.room.TypeConverter;

import com.corona.myapplication.repo.model.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {

    @TypeConverter
    public String fromCountryLangList(List<Province> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Province>>() {}.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public List<Province> toCountryLangList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Province>>() {}.getType();
        List<Province> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }
 }