package controllers

import views.html.helper.FieldConstructor
import views.html.helper.twitterBootstrapFieldConstructor

object BootstrapHelper {

  implicit val fields = FieldConstructor(twitterBootstrapFieldConstructor.f)

}