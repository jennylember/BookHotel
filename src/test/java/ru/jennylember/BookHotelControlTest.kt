package ru.jennylember

import org.junit.jupiter.api.Test

class BookHotelControlTest {

    @Test
    fun test() {
        val dummyInfoGetter = DummyInfoGetter()
        val bookHotelControl = BookHotelControl(dummyInfoGetter)
        bookHotelControl.init()
    }
}