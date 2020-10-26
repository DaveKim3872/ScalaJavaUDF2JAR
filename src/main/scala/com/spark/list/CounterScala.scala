package com.spark.list

import java.{lang, util}

import org.apache.spark.sql.api.java.UDF1

import scala.collection.JavaConverters._

class CounterScala extends UDF1[Seq[lang.Double], util.Map[lang.Double, Integer]]{
  val javaClass = new CounterJava()
  override def call(a: Seq[lang.Double]): util.Map[lang.Double, Integer] = javaClass.countIntList(a.asJava)
}