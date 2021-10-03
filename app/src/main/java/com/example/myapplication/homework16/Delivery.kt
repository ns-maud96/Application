package com.example.myapplication.homework16

sealed class Delivery(
    var deliver: (Order) -> Unit
) {
    data class DeliverySelfPickup(val number: Int) : Delivery({
        println(
            "Заказ $number принят. \nСумма заказа: " + it.getFinalPrice() +
                    "\nИнформация о заказе: " + it + "\nСпособ доставки заказа: самовывоз" + "\n"
        )
    })

    data class CourierDelivery(val number: Int) : Delivery({
        println(
            "Заказ $number принят.  \nСумма заказа: " + it.getFinalPrice() +
                    "\nИнформация о заказе: " + it +
                    "\nСпособ доставки заказа: доставка курьером по адресу " +
                    it.getPrintableAddress() + "\n"
        )
    })

    data class PostServiceDelivery(val number: Int) : Delivery({
        println(
            "Заказ $number принят. \nСумма заказа: " + it.getFinalPrice() +
                    "\nИнформация о заказе: " + it +
                    "\nСпособ доставки заказа: доставка почтой по адресу " +
                    it.getPrintableAddress() + "\n"
        )
    })
}