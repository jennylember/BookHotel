package ru.jennylember

interface InfoGetter {
    fun getGuest(): Guest
    fun getBookInfo(): BookInfo
    fun getHotelId(): String
}