package daos.common

import models.CommonTables._
import slick.driver.H2Driver.api._

abstract class AbstractCodeMasters extends AbstractDao {

  /** create table */
  def createTable = CodeMaster.schema.create

  /** drop table */
  def dropTable = CodeMaster.schema.drop

  /** insert */
  def insert(e: CodeMasterRow) = DBIO.seq(CodeMaster += e)

  /** update */
  def update(e: CodeMasterRow) =
    CodeMaster.filter(t => t.codegrpNo === e.codegrpNo && t.codeValue === e.codeValue).update(e)

  /** delete */
  def remove(codegrpNo: String, codeValue: String) =
    CodeMaster.filter(t => t.codegrpNo === codegrpNo && t.codeValue === codeValue).delete

  /** find by id */
  def filterById(codegrpNo: String, codeValue: String): DBIO[CodeMasterRow] =
    CodeMaster.filter(t => t.codegrpNo === codegrpNo && t.codeValue === codeValue).result.head

  /** find all data */
  def findAll = CodeMaster.sortBy(f => (f.codegrpNo, f.codeValue)).result

  /** filter everything */
  def filter(form: Product): DBIO[Seq[CodeMasterRow]] =
    filter(form, CodeMaster).result

}