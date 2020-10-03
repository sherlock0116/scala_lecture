import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.FunSpec

/**
 * Descriptor:
 * Author: sherlock
 */
class ScalaTest{

}

/*
	calaTest一共提供了七种测试风格，分别为：
		FunSuite，FlatSpec
		FunSpec，WordSpec
		FreeSpec，PropSpec，FeatureSpec。
 */
class SetSuiteWithFunSuite extends AnyFunSuite {

	test("An empty Set should have size 0") {
		assert(Set.empty.size == 0)
	}
	test("Invoking head on an empty Set should produce NoSuchElementException") {
		intercept[NoSuchElementException] {
			Set.empty.head
		}
	}
}

class SetSpecWithFlatSpec extends AnyFlatSpec {
	"An empty Set" should "have size 0" in {
		assert(Set.empty.size == 0)
	}
	it should "produce NoSuchElementException when head is invoked" in {
		intercept[NoSuchElementException] {
			Set.empty.head
		}
	}
}

// 编程风格 太过自由, 可读性低
class SetSpecWithFunSpec extends FunSpec {
	describe("A Set") {
		describe("when empty") {
			it("should have size 0") {
				assert(Set.empty.size == 0)
			}
			it("should produce NoSuchElementException when head is invoked") {
				intercept[NoSuchElementException] {
					Set.empty.head
				}
			}
		}
	}
}


