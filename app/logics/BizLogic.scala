package logics

import play.api.db.slick._
import play.api.mvc._

trait BizLogic {

  def logic:Option[Any] = {None}

  def anyLogic(data: Any)(implicit request:DBSessionRequest[AnyContent]):Option[Any] ={None}

  def intLogic(data: Any)(implicit request:DBSessionRequest[AnyContent]):Option[Int] ={None}

  def intLogic(data: String)(implicit request:DBSessionRequest[AnyContent]):Option[Int] ={None}

  def listLogic(data: Any)(implicit request:DBSessionRequest[AnyContent]):Option[List[Any]] ={None}

}