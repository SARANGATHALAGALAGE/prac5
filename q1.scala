import scala.io.StdIn.readLine

object InventoryManagementSystem {

  // Function to get product list from user input
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

  // Function to print product list with their positions
  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  // Function to get the total number of products
  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  // Main function to demonstrate the functionality
  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println(s"\nTotal number of products: ${getTotalProducts(productList)}")
  }
}

InventoryManagementSystem.main(Array())
