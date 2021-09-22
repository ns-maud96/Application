package com.example.myapplication

sealed class DiscountType() {

    data class FixAmount(val value: Int) : DiscountType()
    data class RangeAmount(val startValue: Int, val endValue: Int) : DiscountType()

    object noAmount : DiscountType()

//    override fun toString(): String {
//        return when (this) {
//            FixAmount -> "FixAmount"
//            RangeAmount -> "RangeAmount"
//        }
//    }
}

