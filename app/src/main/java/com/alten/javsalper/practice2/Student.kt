package com.alten.javsalper.practice2

class Student(
   name: String,
   surname: String,
   val dni: String,
   val email: String,
   val center: String,
   val city: String,
   val photoUrl: String,
   val tutor: String
): Person(name,surname)
