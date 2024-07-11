package repositry


import connections.{MongoComponent, MongoDataBaseComponent}
import domain.Person
import org.mongodb.scala.model.Filters.{equal, notEqual}
import org.mongodb.scala.model.Updates.set
import org.mongodb.scala.result.{DeleteResult, InsertManyResult, InsertOneResult, UpdateResult}

import scala.concurrent.Future

trait PersonComponent {
  this: MongoComponent =>
  def insertPersonRecord(person: Person): Future[InsertOneResult] = {
    collection.insertOne(person).toFuture()
  }

  def insertManyPersonRecord(person: List[Person]): Future[InsertManyResult] = {
    collection.insertMany(person).toFuture()
  }

  def findFirstPersonRecord(): Future[Person] = {
    collection.find().first().toFuture()
  }
  def findAllPersonRecord(): Future[Seq[Person]] = {
    collection.find().toFuture()
  }

  def deleteAllPersonRecord(): Future[DeleteResult] = {
    collection.deleteMany(notEqual("firstName", null)).toFuture()
  }

  def deletePersonRecord(): Future[DeleteResult] = {
    collection.deleteOne(equal("firstName","John")).toFuture()
  }

  def updateAllPersonRecord(): Future[UpdateResult] = {
    collection.updateMany(equal("firstName","John"),set("lastName", "Berners-Lee")).toFuture()
  }

  def updatePersonRecord(): Future[UpdateResult] = {
    collection.updateOne(equal("firstName","John"),set("lastName", "Berners-Lee")).toFuture()
  }
}

object PersonComponent extends PersonComponent with MongoDataBaseComponent