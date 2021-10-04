package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.homework16.Delivery
import com.example.myapplication.homework16.Order
import com.example.myapplication.homework16.PaymentMethod
import com.example.myapplication.homework17_18.Discipline
import com.example.myapplication.homework17_18.Mark
import com.example.myapplication.homework17_18.Student

class MainActivity : AppCompatActivity() {

    var studentList = mutableListOf<Student>()
    var disciplineList = mutableListOf<Discipline>()
    var listOfMarks = mutableListOf<Mark>()
    var averageMark: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        // DONE 3
        val student1 = Student("Ivan", 1)
        val student2 = Student("Kate", 2)
        val student3 = Student("Nick", 3)
        val student4 = Student("Vera", 4)
        val student5 = Student("Alisa", 5)

        studentList = mutableListOf(student1, student2, student3, student4, student5)

        val discipline1 = Discipline("Maths", 1)
        val discipline2 = Discipline("Chemistry", 2)
        val discipline3 = Discipline("English", 3)

        disciplineList = mutableListOf(discipline1, discipline2, discipline3)

        createRandomMarks()
        listOfMarks.forEach { mark -> Log.i("TMS", "$mark") }
        calculateAverageMarkForStudent()
        calculateAverageMarkForDiscipline()
        calculateAverageMarkForClass()
        findGoodAndExcellentStudents()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // DONE 4
    private fun createRandomMarks() {
        studentList.forEach { student ->
            disciplineList.forEach { discipline ->
                listOfMarks.add(
                    Mark(
                        (1..10).random(),
                        student,
                        discipline
                    )
                )
            }
        }
    }

    // DONE 5-6
    private fun calculateAverageMarkForStudent() {
        for (i in 0 until studentList.size) {
            listOfMarks.forEach { mark ->
                if (mark.student.studentId == i + 1) {
                    averageMark += mark.value
                }
            }
            Log.v("TMS", "Cредний балл ученика id${i + 1}: ${averageMark / disciplineList.size}")
            averageMark = 0
        }
    }

    private fun calculateAverageMarkForDiscipline() {
        for (i in 0 until disciplineList.size) {
            listOfMarks.forEach { mark ->
                if (mark.discipline.disciplineId == i + 1) {
                    averageMark += mark.value
                }
            }
            Log.w("TMS", "Cредний балл предмета id${i + 1}: ${averageMark / studentList.size}")
            averageMark = 0
        }
    }

    private fun calculateAverageMarkForClass() {
        listOfMarks.forEach { mark ->
            averageMark += mark.value
        }
        Log.w("TMS", "Cредний балл класса: ${averageMark / listOfMarks.size}")
    }

    // DONE 9*
    private fun findGoodAndExcellentStudents() {
        var counterForExcellentStudents = 0
        var counterForGoodStudents = 0
        for (i in 0 until studentList.size) {
            listOfMarks.forEach {
                if (it.student.studentId == i + 1) {
                    if (it.value >= 9) {
                        counterForExcellentStudents++
                    }
                    if (it.value >= 6) {
                        counterForGoodStudents++
                    }
                }
            }
            when (counterForExcellentStudents) {
                3 -> {
                    Log.e("TMS", "Отличник класса id: ${i + 1}")
                    counterForExcellentStudents = 0
                    counterForGoodStudents = 0
                    continue
                }
                2 -> Log.e("TMS", "Не хватило одной оценки до отличника класса id: ${i + 1}")
            }

            when (counterForGoodStudents) {
                3 -> Log.e("TMS", "Хорошист класса id: ${i + 1}")
                2 -> Log.e("TMS", "Не хватило одной оценки до хорошиста класса id: ${i + 1}")
            }

            counterForExcellentStudents = 0
            counterForGoodStudents = 0
        }
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


