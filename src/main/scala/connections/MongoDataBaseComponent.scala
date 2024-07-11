package connections

import domain.CodecRegistry.codecRegistry
import domain.Person
import org.mongodb.scala.{MongoClient, MongoCollection, MongoDatabase}

trait MongoDataBaseComponent extends MongoComponent {
  val mongoClient: MongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("mydb").withCodecRegistry(codecRegistry)
  val collection: MongoCollection[Person] = database.getCollection("mycollection")
}
