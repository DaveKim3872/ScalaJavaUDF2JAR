package com.spark.list

import java.{lang, util}

import org.apache.spark.sql.api.java.UDF1

import scala.collection.JavaConversions.mapAsScalaMap

class CounterScala extends UDF1[String, util.Map[lang.Double, Integer]]{
  val javaClass = new CounterJava()
  override def call(a: String): util.Map[lang.Double, Integer] = javaClass.countIntList(a)
}