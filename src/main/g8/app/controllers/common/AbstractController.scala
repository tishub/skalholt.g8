package controllers.common

import play.api.mvc._
import scala.language.implicitConversions

trait AbstractController extends Controller {
    implicit def dateToTimestamp(date :java.sql.Date): java.sql.Timestamp = new java.sql.Timestamp(date.getTime)
    implicit def timestampToDatetime(timestamp :java.sql.Timestamp): java.sql.Date = new java.sql.Date(timestamp.getTime)
}