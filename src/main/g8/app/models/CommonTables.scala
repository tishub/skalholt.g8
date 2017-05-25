package models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object CommonTables extends {
  val profile = slick.driver.H2Driver
} with CommonTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait CommonTables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = CodeMaster.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table CodeMaster
    *  @param codegrpNo Database column CODEGRP_NO SqlType(VARCHAR), Length(128,true)
    *  @param codeValue Database column CODE_VALUE SqlType(VARCHAR), Length(128,true)
    *  @param codegrpNm Database column CODEGRP_NM SqlType(VARCHAR), Length(256,true)
    *  @param codeNm Database column CODE_NM SqlType(VARCHAR), Length(256,true)
    *  @param codeNmJa Database column CODE_NM_JA SqlType(VARCHAR), Length(256,true)
    *  @param codeNmEn Database column CODE_NM_EN SqlType(VARCHAR), Length(256,true)
    *  @param codeNmZhCn Database column CODE_NM_ZH_CN SqlType(VARCHAR), Length(256,true)
    *  @param codeNmZhTw Database column CODE_NM_ZH_TW SqlType(VARCHAR), Length(256,true)
    *  @param codeNmZhHk Database column CODE_NM_ZH_HK SqlType(VARCHAR), Length(256,true)
    *  @param extendCodeNm Database column EXTEND_CODE_NM SqlType(VARCHAR), Length(256,true)
    *  @param sortNo Database column SORT_NO SqlType(DECIMAL)
    *  @param parentCodegrpNo Database column PARENT_CODEGRP_NO SqlType(VARCHAR), Length(128,true)
    *  @param parentCodeValue Database column PARENT_CODE_VALUE SqlType(VARCHAR), Length(128,true)
    *  @param insertUserId Database column INSERT_USER_ID SqlType(VARCHAR), Length(128,true)
    *  @param insertPgId Database column INSERT_PG_ID SqlType(VARCHAR), Length(128,true)
    *  @param insertDate Database column INSERT_DATE SqlType(TIMESTAMP)
    *  @param updateUserId Database column UPDATE_USER_ID SqlType(VARCHAR), Length(128,true)
    *  @param updatePgId Database column UPDATE_PG_ID SqlType(VARCHAR), Length(128,true)
    *  @param updateDate Database column UPDATE_DATE SqlType(TIMESTAMP)
    *  @param versionNo Database column VERSION_NO SqlType(INTEGER), Default(1) */
  case class CodeMasterRow(codegrpNo: String, codeValue: String, codegrpNm: String, codeNm: String, codeNmJa: Option[String], codeNmEn: Option[String], codeNmZhCn: Option[String], codeNmZhTw: Option[String], codeNmZhHk: Option[String], extendCodeNm: Option[String], sortNo: scala.math.BigDecimal, parentCodegrpNo: Option[String], parentCodeValue: Option[String], insertUserId: String, insertPgId: String, insertDate: java.sql.Timestamp, updateUserId: String, updatePgId: String, updateDate: java.sql.Timestamp, versionNo: Int = 1)
  /** GetResult implicit for fetching CodeMasterRow objects using plain SQL queries */
  implicit def GetResultCodeMasterRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[scala.math.BigDecimal], e3: GR[java.sql.Timestamp], e4: GR[Int]): GR[CodeMasterRow] = GR{
    prs => import prs._
      CodeMasterRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[scala.math.BigDecimal], <<?[String], <<?[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table CODE_MASTER. Objects of this class serve as prototypes for rows in queries. */
  class CodeMaster(_tableTag: Tag) extends Table[CodeMasterRow](_tableTag, Some("SAMPLE"), "CODE_MASTER") {
    def * = (codegrpNo, codeValue, codegrpNm, codeNm, codeNmJa, codeNmEn, codeNmZhCn, codeNmZhTw, codeNmZhHk, extendCodeNm, sortNo, parentCodegrpNo, parentCodeValue, insertUserId, insertPgId, insertDate, updateUserId, updatePgId, updateDate, versionNo) <> (CodeMasterRow.tupled, CodeMasterRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(codegrpNo), Rep.Some(codeValue), Rep.Some(codegrpNm), Rep.Some(codeNm), codeNmJa, codeNmEn, codeNmZhCn, codeNmZhTw, codeNmZhHk, extendCodeNm, Rep.Some(sortNo), parentCodegrpNo, parentCodeValue, Rep.Some(insertUserId), Rep.Some(insertPgId), Rep.Some(insertDate), Rep.Some(updateUserId), Rep.Some(updatePgId), Rep.Some(updateDate), Rep.Some(versionNo)).shaped.<>({r=>import r._; _1.map(_=> CodeMasterRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10, _11.get, _12, _13, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CODEGRP_NO SqlType(VARCHAR), Length(128,true) */
    val codegrpNo: Rep[String] = column[String]("CODEGRP_NO", O.Length(128,varying=true))
    /** Database column CODE_VALUE SqlType(VARCHAR), Length(128,true) */
    val codeValue: Rep[String] = column[String]("CODE_VALUE", O.Length(128,varying=true))
    /** Database column CODEGRP_NM SqlType(VARCHAR), Length(256,true) */
    val codegrpNm: Rep[String] = column[String]("CODEGRP_NM", O.Length(256,varying=true))
    /** Database column CODE_NM SqlType(VARCHAR), Length(256,true) */
    val codeNm: Rep[String] = column[String]("CODE_NM", O.Length(256,varying=true))
    /** Database column CODE_NM_JA SqlType(VARCHAR), Length(256,true) */
    val codeNmJa: Rep[Option[String]] = column[Option[String]]("CODE_NM_JA", O.Length(256,varying=true))
    /** Database column CODE_NM_EN SqlType(VARCHAR), Length(256,true) */
    val codeNmEn: Rep[Option[String]] = column[Option[String]]("CODE_NM_EN", O.Length(256,varying=true))
    /** Database column CODE_NM_ZH_CN SqlType(VARCHAR), Length(256,true) */
    val codeNmZhCn: Rep[Option[String]] = column[Option[String]]("CODE_NM_ZH_CN", O.Length(256,varying=true))
    /** Database column CODE_NM_ZH_TW SqlType(VARCHAR), Length(256,true) */
    val codeNmZhTw: Rep[Option[String]] = column[Option[String]]("CODE_NM_ZH_TW", O.Length(256,varying=true))
    /** Database column CODE_NM_ZH_HK SqlType(VARCHAR), Length(256,true) */
    val codeNmZhHk: Rep[Option[String]] = column[Option[String]]("CODE_NM_ZH_HK", O.Length(256,varying=true))
    /** Database column EXTEND_CODE_NM SqlType(VARCHAR), Length(256,true) */
    val extendCodeNm: Rep[Option[String]] = column[Option[String]]("EXTEND_CODE_NM", O.Length(256,varying=true))
    /** Database column SORT_NO SqlType(DECIMAL) */
    val sortNo: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("SORT_NO")
    /** Database column PARENT_CODEGRP_NO SqlType(VARCHAR), Length(128,true) */
    val parentCodegrpNo: Rep[Option[String]] = column[Option[String]]("PARENT_CODEGRP_NO", O.Length(128,varying=true))
    /** Database column PARENT_CODE_VALUE SqlType(VARCHAR), Length(128,true) */
    val parentCodeValue: Rep[Option[String]] = column[Option[String]]("PARENT_CODE_VALUE", O.Length(128,varying=true))
    /** Database column INSERT_USER_ID SqlType(VARCHAR), Length(128,true) */
    val insertUserId: Rep[String] = column[String]("INSERT_USER_ID", O.Length(128,varying=true))
    /** Database column INSERT_PG_ID SqlType(VARCHAR), Length(128,true) */
    val insertPgId: Rep[String] = column[String]("INSERT_PG_ID", O.Length(128,varying=true))
    /** Database column INSERT_DATE SqlType(TIMESTAMP) */
    val insertDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("INSERT_DATE")
    /** Database column UPDATE_USER_ID SqlType(VARCHAR), Length(128,true) */
    val updateUserId: Rep[String] = column[String]("UPDATE_USER_ID", O.Length(128,varying=true))
    /** Database column UPDATE_PG_ID SqlType(VARCHAR), Length(128,true) */
    val updatePgId: Rep[String] = column[String]("UPDATE_PG_ID", O.Length(128,varying=true))
    /** Database column UPDATE_DATE SqlType(TIMESTAMP) */
    val updateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("UPDATE_DATE")
    /** Database column VERSION_NO SqlType(INTEGER), Default(1) */
    val versionNo: Rep[Int] = column[Int]("VERSION_NO", O.Default(1))

    /** Primary key of CodeMaster (database name PK_CODE_MASTER) */
    val pk = primaryKey("PK_CODE_MASTER", (codegrpNo, codeValue))
  }
  /** Collection-like TableQuery object for table CodeMaster */
  lazy val CodeMaster = new TableQuery(tag => new CodeMaster(tag))
}