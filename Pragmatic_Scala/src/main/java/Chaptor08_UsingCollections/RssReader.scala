package Chaptor08_UsingCollections

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object RssReader extends App {
	
	println(s"${"=" * 15} 不可变列表 Set ${"=" * 15}")
	
	val feeds1 = Set("blog.toolshed.com", "pragdave.com", "blog.agiledeveloper.com")
	val feeds2 = Set("blog.toolshed.com", "martinfowler.com/bliki")
	
	val blogFeeds: Set[String] = feeds1 filter (_ contains "blog")
	println(s"blog feeds: $blogFeeds")
	
	val mergedFeeds: Set[String] = feeds1 ++ feeds2
	println(s"# of merged feeds: ${mergedFeeds.size}")
	
	val commonFeeds: Set[String] = feeds1 & feeds2
	println(s"common feeds: ${commonFeeds mkString ", "}")
	
	val urls: Set[String] = feeds1 map ("http://" + _)
	println(s"One url: ${urls.head}")
	
	println("Refresh Feeds:")
	feeds1 foreach (feed => println(s" Refreshing $feed ..."))
	
	println(s"${"=" * 15} 关联映射 Map ${"=" * 15}")
	
	val feeds = Map(
		"Andy Hunt" -> "blog.toolshed.com",
		"Dave Thomas" -> "pragdave.com",
		"NFJS" -> "nofluffjuststuff.com/blog"
	)
	
	val filterNameStartWithD: Map[String, String] = feeds filterKeys (_ startsWith "D")
	println(s"# of Filtered: ${filterNameStartWithD.size}")
	
	val filterNameStartWithDAndPragprogInFeed = feeds filter { ele =>
		val (key, value) = ele
		(key startsWith "D") && (value contains "pragdave")
	}
	
	print("# of feeds with auth name D* and progdave in URL:")
	println(filterNameStartWithDAndPragprogInFeed.size)
	
	println(s"Get Andy's Feed: ${feeds.get("Andy Hunt")}")
	println(s"Get Bill's Feed: ${feeds.get("Bill Who")}")
	
	try {
		println(s"Get Andy's Feed Using apply(): ${feeds("Andy Hunt")}")
		println(s"Get Bill's Feed Using apply(): ${feeds("Bill Who")}")
	}catch {
		case _: java.util.NoSuchElementException => println("Not Found")
	}
	
	println(s"${"=" * 15} 不可变列表 List ${"=" * 15}")
	
	val feedList = List("blog.toolshed.com", "pragdave.com", "blog.agiledeveloper.com")
	println(s"First feed: ${feedList.head}")
	println(s"Second feed: ${feedList(1)}")
	println(s"Tail feeds: ${feedList.tail}")
	
	val prefixedList: List[String] = "forums.pragprog.com/forums/87" :: feedList
	println(s"First feed in prefixedList: ${prefixedList.head}")
	println(s"First feed in feedList: ${feedList.head}")
	
	val feedsWithForums: List[String] = feedList ::: List("forums.pragprog.com/forums/87", "forums.pragprog.com/forums/246")
	println(s"First feed in feedsWithForums: ${feedsWithForums.head}")
	println(s"Last feed in feedsWithForums: ${feedsWithForums.last}")
	
	println(s"Feeds with blog: ${feedList.filter(_ contains "blog").mkString(",")}")
	println(s"All Feeds have com: ${feedList forall (_ contains "com")}")
	println(s"All Feeds have dave: ${feedList forall (_ contains "dave")}")
	println(s"Any Feed has dave: ${feedList exists (_ contains "dave")}")
	println(s"Any Feed has bill: ${feedList exists (_ contains "bill")}")
	
	println(s"Feed url lengths: ${feedList.map(_.length).mkString(",")}")
	// foldLeft = /:
	// foldRight = \:
	println(s"Total length of feed url: ${(0 /: feedList){_ + _.length}}")
	println(s"Total length of feed url: ${(feedList :\ 0){_.length + _}}")
}
