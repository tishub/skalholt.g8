package utils

import java.sql.{ Date => SDate }
import java.util.Date

object DateUtils {

  def newSDate = new SDate((new Date()).getTime())
}