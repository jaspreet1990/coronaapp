package com.corona.myapplication.repo.model

data class CoronaInfoBasedOnCountryItem(
    val country: String,
    val date: String,
    val latitude: Double,
    val longitude: Double,
    val provinces: List<Province>
)