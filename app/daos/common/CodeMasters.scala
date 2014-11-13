package daos.common

import models.CommonTables._
import scala.slick.driver.H2Driver.simple._
import play.cache.Cache
import play.api.db.DB
import play.api.Play.current

object CodeMasters extends AbstractCodeMasters {
  /** find by id */
  def filterCodegrpNo(codegrpNo: String) = {

    val codeMasters = Cache.get("codeMasters") match {
      case x: List[_] if (!x.isEmpty) =>
        x.head match {
          case _: CodeMasterRow => x.asInstanceOf[List[CodeMasterRow]]
          case _ => List.empty
        }
      case _ =>
        val codeMasters = getCodeMaster
        Cache.set("codeMasters", codeMasters)
        codeMasters
    }

    for (c <- codeMasters if (c.codegrpNo == codegrpNo)) yield (c.codeValue, c.codeNm)
  }

  /** Database connection */
  def getCodeMaster =
    Database.forDataSource(DB.getDataSource()).withTransaction {
      implicit session: Session =>
        CodeMaster.sortBy(f => (f.codegrpNo, f.codeValue)).list
    }

}