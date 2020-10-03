package com.corona.myapplication.repo.db;

import androidx.room.TypeConverter;

import com.corona.myapplication.repo.model.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<Province> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Province>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Province> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}