package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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

    when (discount.discountType) {
        is DiscountType.FixAmount -> "FixAmountDataClass"
        is DiscountType.RangeAmount -> "RangeAmountDataClass"
        DiscountType.noAmount -> "NoAmountObject"
    }
}