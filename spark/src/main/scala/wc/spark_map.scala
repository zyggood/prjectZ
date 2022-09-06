package wc

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object spark_map {


  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
    val dataRDD1: RDD[Int] = dataRDD.map(
      num => {
        num * 2
      }
    )

    val dataRDD2 = dataRDD1.map(
      num => {
        " " + num
      }
    )
  }

}
