package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.homework16.Delivery
import com.example.myapplication.homework16.Order
import com.example.myapplication.homework16.PaymentMethod

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    var discount = DiscountData(
        3,
        "CatDiscount",
        "The best Cat Discount",
        "hey",
        DiscountType.FixAmount(3)
    )
    println(discount)
    println(discount.discountType.calculate(5))
    discount.discountType = DiscountType.RangeAmount(5, 1)
    println(discount)
    println(discount.discountType.calculate(3))
    println()

    val order1 = Order(
        "Платье",
        1,
        153.0,
        "Солнечная, 4",
        "375292569699", PaymentMethod.ByCreditCard
    )
    val order2 = Order(
        "Носки",
        4,
        5.0,
        "Ясная, 16",
        "375441234567",
        PaymentMethod.OnlinePayment
    )
    val order3 = Order(
        "Брюки",
        1,
        111.0,
        "Светлая, 8",
        "567", PaymentMethod.InCash
    )

    val orders = mutableListOf(order1, order2, order3)

    val delivery1 = Delivery.DeliverySelfPickup(1)
    val delivery2 = Delivery.CourierDelivery(2)
    val delivery3 = Delivery.PostServiceDelivery(3)

    val deliveries: Array<Delivery> = arrayOf(delivery1, delivery2, delivery3)

    orders.forEach { order ->
        deliveries.forEach { delivery -> delivery.deliver(order) }
    }

    delivery1.deliver = { println("Заказ изменен\n") }

    orders.forEach { order ->
        deliveries.forEach { delivery -> delivery.deliver(order) }
    }
}