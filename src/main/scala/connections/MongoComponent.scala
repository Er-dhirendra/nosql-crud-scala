package connections

import domain.Person
import org.mongodb.scala.{MongoClient, MongoCollection, MongoDatabase}

trait MongoComponent {
  val mongoClient: MongoClient
  val database: MongoDatabase
  val collection: MongoCollection[Person]
}
