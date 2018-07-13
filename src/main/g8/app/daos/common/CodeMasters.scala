package daos.common

import models.CommonTables._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import slick.driver.H2Driver.api._
import play.cache.Cache
import play.api.db.DB
import play.api.Play.current

object CodeMasters extends AbstractCodeMasters {
  /** find by id */
  def filterCodegrpNo(codegrpNo: String) = {

    val codeMasters = Cache.get("codeMasters") match {
      case x: Seq[_] if (!x.isEmpty) =>
        x.head match {
          case _: CodeMasterRow => x.asInstanceOf[Seq[CodeMasterRow]]
          case _ => Seq.empty
        }
      case _ =>
        val codeMasters = Await.result(getCodeMaster, Duration.Inf)
        Cache.set("codeMasters", codeMasters)
        codeMasters
    }

    for (c <- codeMasters if (c.codegrpNo == codegrpNo)) yield (c.codeValue, c.codeNm)
  }

  /** Database connection */
  def getCodeMaster =
    Database.forDataSource(DB.getDataSource()).run(CodeMaster.sortBy(f => (f.codegrpNo, f.codeValue)).result)
}