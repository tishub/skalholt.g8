package daos.common

import models.CommonTables._
import scala.collection.immutable.List
import scala.slick.driver.H2Driver.simple._

abstract class AbstractCodeMasters extends AbstractDao {
  /** create table */
  def createTable(implicit s: Session) = CodeMaster.ddl.create

  /** drop table */
  def dropTable(implicit s: Session) = CodeMaster.ddl.drop

  /** insert */
  def insert(e: CodeMasterRow)(implicit s: Session) = CodeMaster.insert(e)

  /** update */
  def update(e: CodeMasterRow)(implicit s: Session) =
    CodeMaster.filter(t => t.codegrpNo === e.codegrpNo && t.codeValue === e.codeValue).update(e)

  /** delete */
  def remove(codegrpNo: String, codeValue: String)(implicit s: Session) =
    CodeMaster.filter(t => t.codegrpNo === codegrpNo && t.codeValue === codeValue).delete

  /** find by id */
  def filterById(codegrpNo: String, codeValue: String)(implicit s: Session): CodeMasterRow =
    CodeMaster.filter(t => t.codegrpNo === codegrpNo && t.codeValue === codeValue).first

  /** find all data */
  def findAll(implicit s: Session) = CodeMaster.sortBy(f => (f.codegrpNo, f.codeValue)).list

  /** filter everything */
  def filter(form: Product)(implicit s: Session): List[CodeMasterRow] =
    filter(form, CodeMaster).list

}