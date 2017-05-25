package daos.common

import java.lang.reflect.Field
import models.CommonTables.CodeMaster
import daos.common.DaoUtil._
import play.api.Play
import slick.driver.JdbcProfile
import play.api.db.slick.{HasDatabaseConfig, DatabaseConfigProvider}
import slick.driver.H2Driver.api._


abstract class AbstractDao extends HasDatabaseConfig[JdbcProfile] {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def filter[A, B](condition: Any, q: Query[A, B, Seq]): Query[A, B, Seq] = {

    def filter[A, B](condition: Any, iterator: Iterator[Field], q: Query[A, B, Seq]): Query[A, B, Seq] = {
      if (!iterator.hasNext) q
      else {
        val field = iterator.next
        field.setAccessible(true)
        val colname = field.getName
        val value = getValue(field.get(condition))
        val filds = field.getAnnotations.filter(
          _.annotationType.getPackage.getName == "utils.annotations.searchcondition").headOption

        field.setAccessible(false)
        if (value == null || value == None || value == "" || filds == null) filter(condition, iterator, q)
        else filter(condition, iterator, qfilter(q, colname, value, filds))
      }
    }
    filter(condition, condition.getClass().getDeclaredFields().iterator, q)
  }

  def joinCm(e: Rep[Option[String]], c: CodeMaster, codeValue: String) = {
    e === c.codeValue && c.codegrpNo === codeValue
  }

}
