val name=List("m","c","y","m","c","x")
def check(name:List[Int],n:Int):Int= {
  name(0) match {
    case _ if(name.isEmpty) => n
    case _ if (name(0) == name.head)=> check(name.tail, n + 1)
    case _ =>check (name.tail, n)

  }
}