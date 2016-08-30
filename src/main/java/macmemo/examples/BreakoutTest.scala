package macmemo.examples

import scala.collection.breakOut
import scala.concurrent.duration._
import com.softwaremill.macmemo.memoize

/**
  * @author Brandon Barker
  *         8/30/2016
  */
object BreakoutTest {

  def main(args: Array[String]): Unit = {

    val myInts = Seq(1, 2, 3, 4, 5)

    //FIXME: currently @memoize breaks type inference for breakout)
    @memoize(maxSize = 10, expiresAfter = 12 hours)
    def getAsList(intsIn: Iterable[Int]): List[Int] = intsIn.map { c => c }(breakOut)

    getAsList(myInts).foreach(ii => println(ii))

  }


}
