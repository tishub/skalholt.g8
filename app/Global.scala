import play.api._
import play.cache.Cache
import daos.common.CodeMasters

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    Cache.set("codeMasters", CodeMasters.getCodeMaster)
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
    Cache.remove("codeMasters")
  }
}