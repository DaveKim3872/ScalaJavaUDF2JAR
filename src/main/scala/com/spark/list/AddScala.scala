package com.spark.list

import org.apache.spark.sql.api.java.UDF3
import org.apache.spark.sql.api.java.UDF1

//class AddScala extends UDF1[String, String] {
//  override def call(input: String):String = input.toUpperCase
//}

class AddScala extends UDF3[String, String, Boolean, String]{
//  val javaClass2 = new AddJava()
  override def call(a: String, b: String, doubleOrNot: Boolean): String = AddJava.Adder(a,b,doubleOrNot)
}
