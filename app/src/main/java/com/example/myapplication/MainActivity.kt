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
        DiscountType.RangeAmount(0, 5)
    )
    println(discount)
    discount.discountType = DiscountType.FixAmount(5)
    println(discount)

    when (discount.discountType) {
        is DiscountType.FixAmount -> "FixAmountDataClass"
        is DiscountType.RangeAmount -> "RangeAmountDataClass"
        DiscountType.noAmount -> "NoAmountObject"
    }
}