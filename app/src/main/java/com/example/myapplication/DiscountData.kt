package com.example.myapplication

data class DiscountData(
    var amount: Int,
    var title: String,
    var description: String,
    var url: String? = null,
    var discountType: DiscountType
) {
    fun getMyTitle() = title.uppercase()
    fun setMyDescription(value: String) {
        description = if (value.length <= 100) {
            value
        } else {
            value.substring(0, 100)
        }
    }

    fun setMyAmount(value: Int) {
        amount = try {
            1 / value
        } catch (exception: ArithmeticException) {
            0
        }
    }

    fun getSafeUrl(): String {
        return url ?: "google.com"
    }

    fun tmp(url: String?): String {
        return url ?: "google.com"
    }
}
