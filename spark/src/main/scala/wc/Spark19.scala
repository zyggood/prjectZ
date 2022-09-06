package wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.io

object Spark19 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkTest").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val data = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3)))

    def seq(a:Int, b:Int): Int = {
      println("seq: " + a + "\t " + b)
      math.max(a, b)
    }

    def comb(a:Int,b:Int):Int={
      println("comb : "+a+"\t"+b)
      a+b
    }
    val result = data.aggregateByKey(0)(seq,comb)  //.collect()
    result.collect().foreach(println)

  }
}
