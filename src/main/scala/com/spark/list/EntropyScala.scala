package com.spark.list

import java.lang

import org.apache.spark.sql.api.java.{UDF1, UDF2, UDF4}

import scala.collection.JavaConverters._

class EntropyScala extends UDF4[Seq[lang.Double], lang.Double, lang.Double, Int, Double]{
  override def call(list_input: Seq[lang.Double], lower_bound: lang.Double, upper_bound: lang.Double, num_bins: Int): Double = CalcListEntropy.calc(list_input.asJava, lower_bound, upper_bound, num_bins)
}
