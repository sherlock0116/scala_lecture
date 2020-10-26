package Chaptor02_Num

import com.github.nscala_time.time.Imports._
import org.joda.time.{DateTime, DateTimeZone}

/**
 * @Description
 * 	nscala-time 对 joda-time 进行了封装
 * @Author sherlock
 * @Date
 */
object NScala_Demo {
	
	val zone = "Asia/Shanghai";
	
	def main(args: Array[String]): Unit = {
		
		val now: DateTime = DateTime.now(DateTimeZone.forID(zone))
		
		println(now)
		println(now.toInstant.getMillis)
		println(now.toString("yyyy-MM-dd HH:mm:ss"))
		
		println(now + 2.months)
	}
}
