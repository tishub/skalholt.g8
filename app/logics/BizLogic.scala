package logics

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait BizLogic {

  def logic:Future[Option[Any]] = {Future{None}}

  def anyLogic(data: Any):Future[Option[Any]] ={Future{None}}

  def intLogic(data: Any):Future[Option[Int]] ={Future{None}}

  def intLogic(data: String):Future[Option[Int]] ={Future{None}}

  def listLogic(data: Any):Future[Option[List[Any]]] ={Future{None}}

}