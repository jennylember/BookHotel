package ru.jennylember

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ConsoleInfoGetter: InfoGetter {

    val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy")

    override fun getGuest(): Guest {
        println("Для бронирования введите ваше имя, фамилию и возраст в формате: Иван Иванов 30")
        val (nameGuest, secondNameGuest, ageGuest) = readLine()!!.split(' ')
        return Guest(nameGuest, secondNameGuest, ageGuest.toInt() - '0'.toInt())
    }

    override fun getBookInfo(): BookInfo {
        println("Введите дату начала проживания, количество ночей и количетсво гостей в формате: 20.04.19 5 2")
        val (dateCheckIn, nights, numberOfGuests) = readLine()!!.split(' ')
        return BookInfo(LocalDate.parse(dateCheckIn, FORMATTER), nights.toInt(), numberOfGuests.toInt())
    }

    override fun provideHotelId(): String {
        println("Введите ID выбранного отеля:")
        return readLine()!!
    }

}