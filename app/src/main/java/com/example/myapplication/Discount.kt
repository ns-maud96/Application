package com.example.myapplication

import java.lang.ArithmeticException
import java.util.*

class Discount {
    var title: String? = null
        get() = field?.uppercase()
    var description: String? = null
        set(value) {
            if (value != null) {
                field = if (value.length <= 100) {
                    value
                } else {
                    value.substring(0, 100)
                }
            } else {
                value
            }
        }
    var amount: Int? = null
        set(value) {
            field = try {
                if (value != null) {
                    1 / value
                } else {
                    0
                }
            } catch (exception: ArithmeticException) {
                0
            }
        }
    var url: String? = null
}