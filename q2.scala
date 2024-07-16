import scala.collection.mutable

case class Book(title: String, author: String, isbn: String)

class Library {
  private val books: mutable.Set[Book] = mutable.Set()

  def addBook(book: Book): Unit = {
    if (books.exists(_.isbn == book.isbn)) {
      println(s"Book with ISBN ${book.isbn} already exists in the collection.")
    } else {
      books += book
      println(s"Book '${book.title}' added to the collection.")
    }
  }

  def removeBook(isbn: String): Unit = {
    val bookToRemove = books.find(_.isbn == isbn)
    bookToRemove match {
      case Some(book) =>
        books -= book
        println(s"Book '${book.title}' removed from the collection.")
      case None =>
        println(s"No book found with ISBN $isbn.")
    }
  }

  def searchBook(isbn: String): Option[Book] = {
    books.find(_.isbn == isbn)
  }

  def listBooks(): Unit = {
    if (books.isEmpty) {
      println("The library has no books.")
    } else {
      println("Books in the library:")
      books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }
  }
}

object LibraryApp extends App {
  val library = new Library

  library.addBook(Book("1984", "George Orwell", "1234567890"))
  library.addBook(Book("Brave New World", "Aldous Huxley", "0987654321"))
  library.addBook(Book("Fahrenheit 451", "Ray Bradbury", "1111111111"))

  library.listBooks()
  
  val searchResult = library.searchBook("1234567890")
  searchResult match {
    case Some(book) => println(s"Found book: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    case None => println("Book not found.")
  }

  library.removeBook("1234567890")

  library.listBooks()
}
