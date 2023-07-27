package com.example.midtermproject

import java.util.Vector

class User(name: String, phone: String, email: String, address: String, point: Int = 0, loyaltyPoint: Int = 0) {
    var name = name
    var phone = phone
    var email = email
    var address = address

    var point = point
    var loyaltyPoint = loyaltyPoint
    val history: Vector<Coffee> = Vector<Coffee>()
    val cart: Vector<Coffee> = Vector<Coffee>()
}
