package com.spark.list

import org.apache.spark.sql.api.java.UDF1

import scala.collection.JavaConversions.mapAsScalaMap

class CounterScala extends UDF1[String, scala.collection.mutable.Map[Integer,Integer]]{
  val javaClass = new CounterJava()
  override def call(a: String): scala.collection.mutable.Map[Integer,Integer] = javaClass.countIntList(a)
}