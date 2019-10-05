package ru.jennylember

import java.time.LocalDate

class DummyInfoGetter: InfoGetter {
    override fun getBookInfo(): BookInfo {
        val data = LocalDate.of(2019, 3, 14)
        return BookInfo(data, 4, 2)
    }

    override fun getGuest(): Guest {
        return Guest("Евгения", "Лемберская", 27)
    }

    override fun getHotelId(): String {
        return "4"
    }

}