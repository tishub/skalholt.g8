import play.api._
//import play.api.mvc._
//import play.api.mvc.Results._
//import scala.concurrent.Future
import play.cache.Cache
import daos.common.CodeMasters

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    Cache.set("codeMasters", CodeMasters.sort)
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
    Cache.remove("codeMasters")
  }

  //override def onError(request: RequestHeader, ex: Throwable) = {
  //    Future.successful(InternalServerError(
  //      views.html.errorPage(ex)
  //    ))
  //  }
  //
  // override def onHandlerNotFound(request: RequestHeader) = {
  //    Future.successful(NotFound(
  //      views.html.notFoundPage(request.path)
  //    ))
  // }
  //
  //  override def onBadRequest(request: RequestHeader, error: String) = {
  //    Future.successful(BadRequest("Bad Request: " + error))
  //  }

}