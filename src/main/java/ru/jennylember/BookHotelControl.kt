package ru.jennylember

import java.lang.RuntimeException

class BookHotelControl(val infoGetter: InfoGetter) {

       fun init() {
           println("Добрый день! Добро пожаловать в сервис бронирования гостинниц!")

           val roomSingle = Room(RoomType.SINGLE, 3600.0)
           val roomDouble = Room(RoomType.DOUBLE, 7600.0)
           val roomTriple = Room(RoomType.TRIPLE, 11899.99)

           val hotel1 = Hotel(
               1,
               "Hotel Pirate Jack",
               "Новокосинская ул. 17-7",
               3,
               listOf(roomSingle, roomDouble, roomDouble)
           )
           val hotel2 = Hotel(
               2,
               "Hotel Moscow",
               "Зубовский бульвар, д.4",
               4,
               listOf(roomTriple, roomSingle, roomSingle)
           )
           val hotel3 = Hotel(
               3,
               "Hotel Evil",
               "Электрозаводская 24",
               2,
               listOf(roomSingle, roomSingle)
           )
           val hotel4 = Hotel(
               4,
               "Hotel Mama Mia",
               "Покровка ул. 16",
               5,
               listOf(roomSingle, roomDouble, roomDouble, roomTriple, roomSingle)
           )
           val hotel5 = Hotel(
               5,
               "Hotel California",
               "Уличная ул. 7",
               3,
               listOf(roomDouble, roomDouble, roomDouble)
           )
           val hotels = setOf(hotel1, hotel2, hotel3, hotel4, hotel5)

           val newGuest = infoGetter.getGuest()
           val bookInfo = infoGetter.getBookInfo()

           availableHotel(bookInfo, hotels)

           val hotelId = infoGetter.provideHotelId()

           val myBooking = getBooking(newGuest, bookInfo, hotelId.toInt(), hotels)

           printBooking(myBooking)
       }



    fun availableHotel(bookInfo: BookInfo, hotels: Set<Hotel>): Set<Int> {
        var i = 0
        var price = 0.0
        val setId  = mutableSetOf<Int>()
        for (hotel in hotels) {
            for (room in (hotel.rooms)) {
                if (!room.isBooked) {
                    if (room.type.ordinal == bookInfo.numberOfGuest) {
                        i++
                        price = room.price
                    }
                }
            }
            if (i > 0) {
                println("Есть номера в отеле: ID ${hotel.ID}, ${hotel.name}, в количестве $i, адрес: ${hotel.address}, звездность: ${hotel.stars}")
                println("Стоимость за ночь: $price")
                setId.add(hotel.ID)
                i = 0
            }
        }
        return setId
    }

    fun getBooking (guest: Guest, bookInfo: BookInfo, hotelId: Int, hotels: Set<Hotel>): Booking {

        for (hotel in hotels) {
            if (hotel.ID == hotelId) {
                for (room in hotel.rooms) {
                    if (!room.isBooked) {
                        if (room.type.ordinal == bookInfo.numberOfGuest) {
                            room.isBooked = true
                            return Booking(
                                hotel,
                                bookInfo,
                                guest,
                                room
                            )
                        }
                    }

                }
            }
        }
        throw RuntimeException("Ошибка бронирования =(")
    }

    fun printBooking(booking: Booking) {
        println("Вы забронировали отель ${booking.hotel.name} по адресу: ${booking.hotel.address}, количество звезд ${booking.hotel.stars}")
        println("На имя: ${booking.guest.name} ${booking.guest.secondName}")
        println("Дата заселения: ${booking.bookInfo.dateCheckIn}, количество ночей ${booking.bookInfo.nights}")
        println("Всего к оплате: ${booking.room.price * booking.bookInfo.nights}")
    }



}