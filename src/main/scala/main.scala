import scala.collection.mutable
case class Scorecard (studentId: Long, marks: Map[Long, Float], percentage: Float)
{

}
case class Students(name:String,studentId:Long,mark:Marks)
case class Marks(studentId:Long,marks: Map[Long,Float])

object main extends App {
  val smarks = new Array[Marks](10)

  val student = new Array[Students](10)

  for (i <- 0 to 5) {
    student(i) = Students(s"mukesh-$i", 1300 + i, Marks(1300 + i, Map(101l -> (i + 23.0f), 102l -> 33.0f, 103l -> 44.0f)))
  }
  for (i <- 5 to 9) {
    student(i) = Students(s"mukesh", 1300 + i, Marks(1300 + i, Map(101l -> (i + 23.0f), 102l -> 33.0f, 103l -> 44.0f)))
  }

  val studentcounts = mutable.Map.empty[String, List[Scorecard]]


  def countchecker(a:Int):Int= {
    var count = 0
    for (i <- 0 to a) {
      if (student(i).name == student(a).name)
        count += 1
    }
    count
  }
  def indexcheker(b:Int):Int={
    var index=0
    for (k <- 0 to b)
      { if(student(k).name == student(b).name && index==0)
        index=k
      }
   index
  }

      for (i <- 0 to 9) {

        val percentage = (student(i).mark.marks(101) + student(i).mark.marks(102) + student(i).mark.marks(103)) / 3

          studentcounts.keys match  {
           case _ if !(studentcounts.contains(student(i).name)) =>studentcounts+=(student(i).name ->List[Scorecard](Scorecard(student(i).studentId, student(i).mark.marks, percentage)))

          case _ if (studentcounts.contains(student(i).name)) => studentcounts+=(student(indexcheker(i)).name ->(Scorecard(student(i).studentId, student(i).mark.marks, percentage)::studentcounts(student(indexcheker(i)).name)))
        }
      }





  println(studentcounts)

}



