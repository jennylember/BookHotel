package ru.jennylember

data class Booking (val hotel: Hotel, val bookInfo: BookInfo, var guest: Guest, var room: Room) {
}