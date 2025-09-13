import scala.io.StdIn.readLine

object WordsNumbersAnalyze {
  def main(args: Array[String]): Unit = {

//    Collect user's info
    println("Enter your infomation here:")
    val info = readLine()

//    Clean the info
    val cleaned = info.toUpperCase.replaceAll("[^A-Z0-9\\s]", "")

    println(s"You have Entered: $cleaned")

//    Split it into some groups
    val splited = cleaned.split("\\s")

// Group the words
    val grouped = splited.groupBy(identity)

//    Count their occurence
    val counted = grouped.view.mapValues(_ .length)

    counted.foreach{case (word, count) =>
      println(s"Word $word occured $count times")
    }

//    Find the average of the word(S)
    val lengths = splited.map(_. length)
    val average = lengths.sum.toDouble / lengths.length

    println(s"The word(S) average is: $average")
//Find the longest word
    val longest = splited.maxBy(_.length)

    println(s"The longest word is: $longest")
  }
}