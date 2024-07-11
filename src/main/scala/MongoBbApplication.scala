import repositry.PersonComponent

import scala.concurrent.ExecutionContext.Implicits.global

object MongoBbApplication extends App{

  PersonComponent.findAllPersonRecord.foreach(person =>
  println("=====PersonComponent==" + person)
  )
}
