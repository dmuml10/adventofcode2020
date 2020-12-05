package ge.dm

object Day3TobogganTrajectory1 {

  val numRows = 323
  val numColumns = 31

  def main(args: Array[String]): Unit = {
    print(solve("src/resources/TobogganTrajectory.txt"))
  }

  def readFile(filename: String): Array[Array[Char]] = {
    val matrix = Array.ofDim[Char](numRows,numColumns)

    val bufferedSource = io.Source.fromFile(filename)

    var row = 0;
    var column = 0
    for (line <- bufferedSource.getLines()) {
      for (char <- line) {
        matrix(row)(column) = char
        column += 1
      }
      row += 1
      column = 0
    }

    bufferedSource.close
    matrix
  }


  def solve(filename: String): Int = {
    val matrix = readFile(filename)

    calculate(1, 3, matrix)
  }

  private def calculate(r: Int, c: Int, array: Array[Array[Char]]): Int =  {
    var column: Int = 0
    var row: Int = 0
    var counter: Int = 0
    while ( row < numRows)  {
      column = column % numColumns
      if (array(row)(column) == '#')  {
        counter += 1
      }
      row += r
      column += c
    }
    counter
  }


  /*
  private def calculate(r: Int, c: Int, array: Array[Array[Char]]): Int =  { var column: Int = 0
    var row: Int = 0
    var counter: Int = 0
    while ( { row < 323})  { column = column % 31
    if (array(row)(column) == '#')  { counter += 1
    }
    row += r
    column += c
    }
    System.out.println(counter)
    return counter
}
   */

}
