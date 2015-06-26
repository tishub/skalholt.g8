package models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.H2Driver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = Event.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Event
   *  @param id Database column ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param eventId Database column EVENT_ID SqlType(VARCHAR), Length(100,true)
   *  @param eventNm Database column EVENT_NM SqlType(VARCHAR), Length(100,true)
   *  @param eventDate Database column EVENT_DATE SqlType(DATE)
   *  @param homepage Database column HOMEPAGE SqlType(VARCHAR), Length(500,true)
   *  @param place Database column PLACE SqlType(VARCHAR), Length(100,true)
   *  @param capacity Database column CAPACITY SqlType(VARCHAR), Length(100,true)
   *  @param eventType Database column EVENT_TYPE SqlType(VARCHAR), Length(100,true)
   *  @param content Database column CONTENT SqlType(VARCHAR), Length(1000,true)
   *  @param publicStatus Database column PUBLIC_STATUS SqlType(VARCHAR), Length(100,true) */
  case class EventRow(id: Int, eventId: String, eventNm: String, eventDate: Option[java.sql.Date], homepage: Option[String], place: Option[String], capacity: Option[String], eventType: Option[String], content: Option[String], publicStatus: Option[String])
  /** GetResult implicit for fetching EventRow objects using plain SQL queries */
  implicit def GetResultEventRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Date]], e3: GR[Option[String]]): GR[EventRow] = GR{
    prs => import prs._
    EventRow.tupled((<<[Int], <<[String], <<[String], <<?[java.sql.Date], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table EVENT. Objects of this class serve as prototypes for rows in queries. */
  class Event(_tableTag: Tag) extends Table[EventRow](_tableTag, Some("SAMPLE"), "EVENT") {
    def * = (id, eventId, eventNm, eventDate, homepage, place, capacity, eventType, content, publicStatus) <> (EventRow.tupled, EventRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(eventId), Rep.Some(eventNm), eventDate, homepage, place, capacity, eventType, content, publicStatus).shaped.<>({r=>import r._; _1.map(_=> EventRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column EVENT_ID SqlType(VARCHAR), Length(100,true) */
    val eventId: Rep[String] = column[String]("EVENT_ID", O.Length(100,varying=true))
    /** Database column EVENT_NM SqlType(VARCHAR), Length(100,true) */
    val eventNm: Rep[String] = column[String]("EVENT_NM", O.Length(100,varying=true))
    /** Database column EVENT_DATE SqlType(DATE) */
    val eventDate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("EVENT_DATE")
    /** Database column HOMEPAGE SqlType(VARCHAR), Length(500,true) */
    val homepage: Rep[Option[String]] = column[Option[String]]("HOMEPAGE", O.Length(500,varying=true))
    /** Database column PLACE SqlType(VARCHAR), Length(100,true) */
    val place: Rep[Option[String]] = column[Option[String]]("PLACE", O.Length(100,varying=true))
    /** Database column CAPACITY SqlType(VARCHAR), Length(100,true) */
    val capacity: Rep[Option[String]] = column[Option[String]]("CAPACITY", O.Length(100,varying=true))
    /** Database column EVENT_TYPE SqlType(VARCHAR), Length(100,true) */
    val eventType: Rep[Option[String]] = column[Option[String]]("EVENT_TYPE", O.Length(100,varying=true))
    /** Database column CONTENT SqlType(VARCHAR), Length(1000,true) */
    val content: Rep[Option[String]] = column[Option[String]]("CONTENT", O.Length(1000,varying=true))
    /** Database column PUBLIC_STATUS SqlType(VARCHAR), Length(100,true) */
    val publicStatus: Rep[Option[String]] = column[Option[String]]("PUBLIC_STATUS", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Event */
  lazy val Event = new TableQuery(tag => new Event(tag))
}
