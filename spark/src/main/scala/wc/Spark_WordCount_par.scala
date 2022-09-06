package wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_WordCount_par {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val lines: RDD[String] = sc.textFile("data",2)

    lines.saveAsTextFile("output")


    //分组和聚合


    sc.stop()

  }
}
