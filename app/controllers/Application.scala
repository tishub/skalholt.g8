package controllers

import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Application extends Controller {

  def index = Action.async { implicit request =>
    Future {
      Ok(views.html.index("Your new application is ready."))
    }
  }

}