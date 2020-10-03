package cgs.scala.future

import java.util.concurrent.TimeUnit

import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
import scala.util.{Failure, Success}

/**
 * @Project: scala_lecture
 * @Description: TODO
 * @author: sherlock
 * @date Date: 
 */
object Government extends App {

	def redeemCampaignPledge() = {
		val promise: Promise[TaxCut] = Promise[TaxCut]()
		Future {
			println("Starting the new legislative period.")
			TimeUnit.SECONDS.sleep(3L)
			promise.success(TaxCut(15))
			println("We reduced the taxes! You must reelect us !")
		}
		promise.future
	}

	val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
	println("Now that they're elected, let's see if they remember their promises...")
	taxCutF.onComplete {
		case Success(TaxCut(reduction)) =>
			println(s"A miracle! They really cut our taxes by $reduction percentage points!")
		case Failure(ex) =>
			println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
	}
	StdIn.readLine()
}

case class TaxCut(reduction: Int)