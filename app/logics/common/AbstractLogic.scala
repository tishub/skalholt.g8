package logics.common

import slick.driver.JdbcProfile
import play.api.db.slick.{HasDatabaseConfig, DatabaseConfigProvider}
import play.api.Play

trait AbstractLogic extends HasDatabaseConfig[JdbcProfile] {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
}
