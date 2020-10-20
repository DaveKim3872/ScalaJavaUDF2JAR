package com.spark.list

import org.apache.spark.sql.api.java.{UDF1, UDF2}

import scala.collection.JavaConversions.mapAsScalaMap

class EntropyScala extends UDF2[String, Int, Double]{
  override def call(a: String, b: Int): Double = CalcListEntropy.calc(a, b)
}
