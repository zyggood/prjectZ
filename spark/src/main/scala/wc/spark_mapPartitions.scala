package wc

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object spark_mapPartitions {


  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)
    val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
    dataRDD.mapPartitions(
      data => data.filter(_ % 2 == 0)
    ).collect.foreach(println)

    dataRDD.mapPartitionsWithIndex(
      (index, data) => {
        data.filter(_ % 2 == 0)
      }
    ).collect.foreach(println)
  }

}
