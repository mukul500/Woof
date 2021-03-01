package net.xblacky.woof.model

data class Dog(
    val id: Int,
    val name: String,
    val age: Double,
    val gender: String,
    val color: String,
    val location: String,
    val smallImage: Int,
    val largeImage: Int,
    val about: String,
    val breed: String
)