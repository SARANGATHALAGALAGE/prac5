object Fibonacci {

  def fib(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }
  
  def printFibonacci(n: Int): Unit = {
    def loop(i: Int): Unit = {
      if (i < n) {
        print(fib(i) + " ")
        loop(i + 1)
      }
    }
    loop(0)
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    printFibonacci(n)
  }
}
