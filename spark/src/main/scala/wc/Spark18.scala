package wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark18 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val RDD = sc.parallelize(List(
      ("a", 1), ("a", 2), ("b", 3), ("b", 4), ("b", 5), ("b", 6)
    ))




  }
}
