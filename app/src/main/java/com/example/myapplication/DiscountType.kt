package com.example.myapplication

sealed class DiscountType(val calculate: (Int) -> String) {

    data class FixAmount(val value: Int) : DiscountType({
        (it * value).toString()
    })

    data class RangeAmount(val startValue: Int, val endValue: Int) : DiscountType({
        ((startValue + endValue) / 2 * it).toString()
    })

    object noAmount : DiscountType({
        "zero"
    })

//    override fun toString(): String {
//        return when (this) {
//            FixAmount -> "FixAmount"
//            RangeAmount -> "RangeAmount"
//        }
//    }
}

