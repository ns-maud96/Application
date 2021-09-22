package com.example.myapplication

data class DiscountData(
    var amount: Int,
    var title: String,
    var description: String,
    var url: String
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
            if (value != null) {
                1 / value
            } else {
                0
            }
        } catch (exception: ArithmeticException) {
            0
        }
    }
}
