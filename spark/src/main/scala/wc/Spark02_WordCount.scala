package wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val lines: RDD[String] = sc.textFile("data")
    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordAndOne = words.map(word => (word, 1))
    val wordGroup = wordAndOne.groupBy(x => x._1)

    wordGroup.map{
      case (word, list) => {
        list.reduce(
          (a1, a2) => (a1._1 , a1._2 + a2._2)
        )
      }
    }.foreach(println)



    val value1 = sc.makeRDD(List(1, 2, 3, 4))
    val value2 = sc.makeRDD(List(1, 2, 5, 6))

    value1.union(value2).foreach(println)
    value1.intersection(value2)
    value1.subtract(value2)

    sc.stop()
  }
}
