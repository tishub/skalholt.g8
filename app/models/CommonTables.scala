package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object CommonTables extends {
  val profile = scala.slick.driver.H2Driver
} with CommonTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait CommonTables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for CodeMaster where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{ GetResult => GR }

  /** DDL for all CodeMaster. Call .create to execute. */
  lazy val ddl = CodeMaster.ddl

  /**
   * Entity class storing rows of table CodeMaster
   *  @param codegrpNo Database column CODEGRP_NO
   *  @param codeValue Database column CODE_VALUE
   *  @param codegrpNm Database column CODEGRP_NM
   *  @param codeNm Database column CODE_NM
   *  @param codeNmJa Database column CODE_NM_JA
   *  @param codeNmEn Database column CODE_NM_EN
   *  @param codeNmZhCn Database column CODE_NM_ZH_CN
   *  @param codeNmZhTw Database column CODE_NM_ZH_TW
   *  @param codeNmZhHk Database column CODE_NM_ZH_HK
   *  @param extendCodeNm Database column EXTEND_CODE_NM
   *  @param sortNo Database column SORT_NO
   *  @param parentCodegrpNo Database column PARENT_CODEGRP_NO
   *  @param parentCodeValue Database column PARENT_CODE_VALUE
   *  @param insertUserId Database column INSERT_USER_ID
   *  @param insertPgId Database column INSERT_PG_ID
   *  @param insertDate Database column INSERT_DATE
   *  @param updateUserId Database column UPDATE_USER_ID
   *  @param updatePgId Database column UPDATE_PG_ID
   *  @param updateDate Database column UPDATE_DATE
   *  @param versionNo Database column VERSION_NO Default(1)
   */
  case class CodeMasterRow(codegrpNo: String, codeValue: String, codegrpNm: String, codeNm: String, codeNmJa: Option[String], codeNmEn: Option[String], codeNmZhCn: Option[String], codeNmZhTw: Option[String], codeNmZhHk: Option[String], extendCodeNm: Option[String], sortNo: scala.math.BigDecimal, parentCodegrpNo: Option[String], parentCodeValue: Option[String], insertUserId: String, insertPgId: String, insertDate: java.sql.Timestamp, updateUserId: String, updatePgId: String, updateDate: java.sql.Timestamp, versionNo: Int = 1)
  /** GetResult implicit for fetching CodeMasterRow objects using plain SQL queries */
  implicit def GetResultCodeMasterRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[scala.math.BigDecimal], e3: GR[java.sql.Timestamp], e4: GR[Int]): GR[CodeMasterRow] = GR {
    prs =>
      import prs._
      CodeMasterRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[scala.math.BigDecimal], <<?[String], <<?[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table CODE_MASTER. Objects of this class serve as prototypes for rows in queries. */
  class CodeMaster(_tableTag: Tag) extends Table[CodeMasterRow](_tableTag, Some("SAMPLE"), "CODE_MASTER") {
    def * = (codegrpNo, codeValue, codegrpNm, codeNm, codeNmJa, codeNmEn, codeNmZhCn, codeNmZhTw, codeNmZhHk, extendCodeNm, sortNo, parentCodegrpNo, parentCodeValue, insertUserId, insertPgId, insertDate, updateUserId, updatePgId, updateDate, versionNo) <> (CodeMasterRow.tupled, CodeMasterRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (codegrpNo.?, codeValue.?, codegrpNm.?, codeNm.?, codeNmJa, codeNmEn, codeNmZhCn, codeNmZhTw, codeNmZhHk, extendCodeNm, sortNo.?, parentCodegrpNo, parentCodeValue, insertUserId.?, insertPgId.?, insertDate.?, updateUserId.?, updatePgId.?, updateDate.?, versionNo.?).shaped.<>({ r => import r._; _1.map(_ => CodeMasterRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10, _11.get, _12, _13, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column CODEGRP_NO  */
    val codegrpNo: Column[String] = column[String]("CODEGRP_NO")
    /** Database column CODE_VALUE  */
    val codeValue: Column[String] = column[String]("CODE_VALUE")
    /** Database column CODEGRP_NM  */
    val codegrpNm: Column[String] = column[String]("CODEGRP_NM")
    /** Database column CODE_NM  */
    val codeNm: Column[String] = column[String]("CODE_NM")
    /** Database column CODE_NM_JA  */
    val codeNmJa: Column[Option[String]] = column[Option[String]]("CODE_NM_JA")
    /** Database column CODE_NM_EN  */
    val codeNmEn: Column[Option[String]] = column[Option[String]]("CODE_NM_EN")
    /** Database column CODE_NM_ZH_CN  */
    val codeNmZhCn: Column[Option[String]] = column[Option[String]]("CODE_NM_ZH_CN")
    /** Database column CODE_NM_ZH_TW  */
    val codeNmZhTw: Column[Option[String]] = column[Option[String]]("CODE_NM_ZH_TW")
    /** Database column CODE_NM_ZH_HK  */
    val codeNmZhHk: Column[Option[String]] = column[Option[String]]("CODE_NM_ZH_HK")
    /** Database column EXTEND_CODE_NM  */
    val extendCodeNm: Column[Option[String]] = column[Option[String]]("EXTEND_CODE_NM")
    /** Database column SORT_NO  */
    val sortNo: Column[scala.math.BigDecimal] = column[scala.math.BigDecimal]("SORT_NO")
    /** Database column PARENT_CODEGRP_NO  */
    val parentCodegrpNo: Column[Option[String]] = column[Option[String]]("PARENT_CODEGRP_NO")
    /** Database column PARENT_CODE_VALUE  */
    val parentCodeValue: Column[Option[String]] = column[Option[String]]("PARENT_CODE_VALUE")
    /** Database column INSERT_USER_ID  */
    val insertUserId: Column[String] = column[String]("INSERT_USER_ID")
    /** Database column INSERT_PG_ID  */
    val insertPgId: Column[String] = column[String]("INSERT_PG_ID")
    /** Database column INSERT_DATE  */
    val insertDate: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("INSERT_DATE")
    /** Database column UPDATE_USER_ID  */
    val updateUserId: Column[String] = column[String]("UPDATE_USER_ID")
    /** Database column UPDATE_PG_ID  */
    val updatePgId: Column[String] = column[String]("UPDATE_PG_ID")
    /** Database column UPDATE_DATE  */
    val updateDate: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("UPDATE_DATE")
    /** Database column VERSION_NO Default(1) */
    val versionNo: Column[Int] = column[Int]("VERSION_NO", O.Default(1))

    /** Primary key of CodeMaster (database name PK_CODE_MASTER) */
    val pk = primaryKey("PK_CODE_MASTER", (codegrpNo, codeValue))
  }
  /** Collection-like TableQuery object for table CodeMaster */
  lazy val CodeMaster = new TableQuery(tag => new CodeMaster(tag))
}