package controllers.common

import play.api._
import play.api.mvc._
import play.api.mvc.Request
import play.api.mvc.Result

abstract class CommonController extends Controller {

  val success = "success"

  def CommonAction(f: Request[AnyContent] => Result): Action[AnyContent] = {
      LoggingAction {
        request =>
        f(request)
      }
  }

  def LoggingAction(f: Request[AnyContent] => Result): Action[AnyContent] = {
    Action { request =>
      Logger.info("--- Action start ---" + f.getClass().getName())
      val ret = f(request)
      Logger.info("--- Action end   ---" + f.getClass().getName())
      ret
    }
  }
}