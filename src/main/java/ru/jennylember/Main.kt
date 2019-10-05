package ru.jennylember

fun main() {
    val infoGetter = ConsoleInfoGetter()
    val bookHotelControl = BookHotelControl(infoGetter)
    bookHotelControl.init()
}