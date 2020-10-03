package com.corona.myapplication.repo.model

data class CountryResponseItem(
    val alpha2code: String,
    val alpha3code: String,
    val latitude: Double,
    val longitude: Double,
    val name: String
)