import scala.io.StdIn.readLine

object InventoryManagementSystem {
  
  def getProductList(): List[String] = {
    var products = List[String]()
    var input = ""

    while (input != "done") {
      println("Enter product name (or type 'done' to finish): ")
      input = readLine()
      if (input != "done") {
        products = products :+ input
      }
    }
    products
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println(s"\nTotal number of products: ${getTotalProducts(productList)}")
  }
}

InventoryManagementSystem.main(Array())
