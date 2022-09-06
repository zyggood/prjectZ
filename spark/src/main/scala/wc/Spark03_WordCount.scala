package wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Random

object Spark03_WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val lines: RDD[String] = sc.textFile("data")
    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordGroup = words.map(x => ((x, getsuiji()), 1))
    println(wordGroup.countByKey().toSeq.sortBy(_._2).reverse.toString())
    wordGroup.reduceByKey(_ + _).foreach(println)
    println("=========")
    wordGroup.groupByKey().map(x => (x._1, Sum(x._2))).foreach(println)
//
//    var seq = Seq[Int](1,2,3,4)
//    var rdd: RDD[Int] = sc.makeRDD(seq)
//    rdd.collect.foreach(println)



    //分组和聚合


    sc.stop()

  }

  def Sum(ints: Iterable[Int]) ={
    val events = ints.toList
    var sum = 0
    for (i <- events) {
      sum = sum + i
    }
    sum
  }

  def getsuiji() ={
    var random = new Random()
    val prefix = random.nextInt(2)
    prefix
  }
}
