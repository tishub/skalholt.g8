package daos.common

import slick.driver.H2Driver.api._
import play.Logger
import utils.annotations.searchcondition._

object DaoUtil {

  def qfilter[A, B](q: Query[A, B, Seq], colname: String, value: Any, condition: Any): Query[A, B, Seq] = {
    Logger.debug("value::" + value + ":" + value.getClass)
    Logger.debug("condition::" + condition + ":" + condition.getClass)
    try {
      q.filter { row =>
        val field = row.getClass().getDeclaredField(colname)
        field.setAccessible(true)
        val gotField = field.get(row)
        field.setAccessible(false)

        Logger.debug("gotField:" + gotField)
        value match {
          case Some(x) =>
            filedMatching(gotField, x, condition)
          case x =>
            filedMatching(gotField, x, condition)
        }
      }
    } catch {
      case e: NoSuchFieldException => q
    }
  }

  def filedMatching(field: Any, value: Any, condition: Any): Rep[Boolean] =
    value match {
      case p: List[t] if (p.isEmpty) =>
        Logger.warn("no match type[" + value.getClass + "]:" + value)
        new LiteralColumn(true)
      case p: List[t] =>
        p(0) match {
          case x: String =>
            condmatchString(condition, field.asInstanceOf[Rep[String]], value.asInstanceOf[List[String]])
          case x: Int =>
            condmatchInt(condition, field.asInstanceOf[Rep[Int]], value.asInstanceOf[List[Int]])
          case x: Boolean =>
            condmatchBoolean(condition, field.asInstanceOf[Rep[Boolean]], value.asInstanceOf[List[Boolean]])
          case x: Byte =>
            condmatchByte(condition, field.asInstanceOf[Rep[Byte]], value.asInstanceOf[List[Byte]])
          case x: Short =>
            condmatchShort(condition, field.asInstanceOf[Rep[Short]], value.asInstanceOf[List[Short]])
          case x: Long =>
            condmatchLong(condition, field.asInstanceOf[Rep[Long]], value.asInstanceOf[List[Long]])
          case x: BigDecimal =>
            condmatchBigDecimal(condition, field.asInstanceOf[Rep[BigDecimal]], value.asInstanceOf[List[BigDecimal]])
          case x: Double =>
            condmatchDouble(condition, field.asInstanceOf[Rep[Double]], value.asInstanceOf[List[Double]])
          case x: Float =>
            condmatchFloat(condition, field.asInstanceOf[Rep[Float]], value.asInstanceOf[List[Float]])
          case x: java.sql.Date =>
            condmatchDate(condition, field.asInstanceOf[Rep[java.sql.Date]], value.asInstanceOf[List[java.sql.Date]])
          case x: java.sql.Timestamp =>
            condmatchTimestamp(condition, field.asInstanceOf[Rep[java.sql.Timestamp]], value.asInstanceOf[List[java.sql.Timestamp]])
          case _ =>
            Logger.warn("no match type[" + value.getClass + "]:" + value)
            new LiteralColumn(true)
        }
      case x: String =>
        condmatch(condition, field.asInstanceOf[Rep[String]], value.asInstanceOf[String])
      case x: Int =>
        condmatch(condition, field.asInstanceOf[Rep[Int]], value.asInstanceOf[Int])
      case x: Boolean =>
        condmatch(condition, field.asInstanceOf[Rep[Boolean]], value.asInstanceOf[Boolean])
      case x: Byte =>
        condmatch(condition, field.asInstanceOf[Rep[Byte]], value.asInstanceOf[Byte])
      case x: Short =>
        condmatch(condition, field.asInstanceOf[Rep[Short]], value.asInstanceOf[Short])
      case x: Long =>
        condmatch(condition, field.asInstanceOf[Rep[Long]], value.asInstanceOf[Long])
      case x: BigDecimal =>
        condmatch(condition, field.asInstanceOf[Rep[BigDecimal]], value.asInstanceOf[BigDecimal])
      case x: Double =>
        condmatch(condition, field.asInstanceOf[Rep[Double]], value.asInstanceOf[Double])
      case x: Float =>
        condmatch(condition, field.asInstanceOf[Rep[Float]], value.asInstanceOf[Float])
      case x: java.sql.Date =>
        condmatch(condition, field.asInstanceOf[Rep[java.sql.Date]], value.asInstanceOf[java.sql.Date])
      case x: java.sql.Timestamp =>
        condmatch(condition, field.asInstanceOf[Rep[java.sql.Timestamp]], value.asInstanceOf[java.sql.Timestamp])
      case _ =>
        Logger.warn("no match type[" + value.getClass + "]:" + value)
        new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[String], value: String): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case x: Contains => col like s"%$value%"
          case x: StartWith => col like s"$value%"
          case x: EndWith => col like s"%$value"
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchString(condition: Any, col: Rep[String], value: List[String]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Int], value: Int): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchInt(condition: Any, col: Rep[Int], value: List[Int]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Boolean], value: Boolean): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchBoolean(condition: Any, col: Rep[Boolean], value: List[Boolean]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Byte], value: Byte): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchByte(condition: Any, col: Rep[Byte], value: List[Byte]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Short], value: Short): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchShort(condition: Any, col: Rep[Short], value: List[Short]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Long], value: Long): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchLong(condition: Any, col: Rep[Long], value: List[Long]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[BigDecimal], value: BigDecimal): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchBigDecimal(condition: Any, col: Rep[BigDecimal], value: List[BigDecimal]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Double], value: Double): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchDouble(condition: Any, col: Rep[Double], value: List[Double]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[Float], value: Float): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchFloat(condition: Any, col: Rep[Float], value: List[Float]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[java.sql.Date], value: java.sql.Date): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchDate(condition: Any, col: Rep[java.sql.Date], value: List[java.sql.Date]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def condmatch(condition: Any, col: Rep[java.sql.Timestamp], value: java.sql.Timestamp): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: Eq => col === value
          case x: Ne => col =!= value
          case x: Lt => col < value
          case x: Le => col <= value
          case x: Gt => col > value
          case x: Ge => col >= value
          case _ => col === value
        }
      case _ => new LiteralColumn(true)
    }

  def condmatchTimestamp(condition: Any, col: Rep[java.sql.Timestamp], value: List[java.sql.Timestamp]): Rep[Boolean] =
    condition match {
      case Some(c) =>
        c match {
          case x: In => col inSet value
          case _ => new LiteralColumn(true)
        }
      case _ => new LiteralColumn(true)
    }

  def getValue[T](c: T) = c.asInstanceOf[T]
}
