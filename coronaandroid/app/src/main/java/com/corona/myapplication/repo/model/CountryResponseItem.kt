package com.corona.myapplication.repo.model

data class CountryResponseItem(
    var alpha2code: String,
    var alpha3code: String,
    var latitude: Double,
    var longitude: Double,
    var name: String
)