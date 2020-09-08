package com.rodrigotristany.kincarta.domain.entities

class Contact (
    val name : String?,
    val id : Int,
    val companyName : String?,
    val isFavorite : Boolean,
    val smallImageURL : String?,
    val largeImageURL : String?,
    val emailAddress : String?,
    val birthDate : String?,
    val phone : Phone,
    val address : Address
)