package com.example.myapplication.homework16

data class Order(
    val name: String,
    val amount: Int,
    val price: Double,
    val address: String,
    val phoneNumber: String,
    val paymentMethod: PaymentMethod
) {
    fun getFinalPrice(): Double {
        return if (amount >= 3) {
            price * amount * 0.95
        } else {
            price * amount
        }
    }

    fun getPrintableAddress(): String {
        return address.lowercase()
    }
}