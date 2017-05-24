package logics.common

import slick.driver.JdbcProfile
import play.api.db.slick.{HasDatabaseConfig, DatabaseConfigProvider}
import play.api.Play
import scala.language.implicitConversions

trait AbstractLogic extends HasDatabaseConfig[JdbcProfile] {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  implicit def dateToTimestamp(date :java.sql.Date): java.sql.Timestamp = new java.sql.Timestamp(date.getTime)
  implicit def timestampToDatetime(timestamp :java.sql.Timestamp): java.sql.Date = new java.sql.Date(timestamp.getTime)
}
