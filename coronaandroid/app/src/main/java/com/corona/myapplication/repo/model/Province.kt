package com.corona.myapplication.repo.model

data class Province(
    val active: Int,
    val confirmed: Int,
    val deaths: Int,
    val province: String,
    val recovered: Int
)