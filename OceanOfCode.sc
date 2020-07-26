
import java.util._
import java.io._
import java.math._
import scala.util.control.Breaks._

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Ship(var position: Array[Int], var dir: Char, var id: Int) {

  def getPosition: Array[Int] = position

  def setPosition(position: Array[Int]): Unit = {
    this.position = position
  }

  def getDir: Char = dir

  def setDir(dir: Char): Unit = {
    this.dir = dir
  }

  def getId: Int = id

  def setId(id: Int): Unit = {
    this.id = id
  }

  override def toString: String = "Ship [position=" + position.toString + ", dir=" + dir + ", id=" + id + "]"

  //MOVE THE SHIP OF N|E|W|S DIRECTIONS
  def move(cellValues: Array[Array[Char]]): Boolean = {
    val startPosition = this.getPosition
    System.err.println("Actual position before move: " + startPosition(0) + " " + startPosition(1))
    if (((startPosition(0) + 1) < cellValues.length) && (cellValues(startPosition(0) + 1)(startPosition(1)) == '.')) {
      this.setPosition(Array[Int](startPosition(0) + 1, startPosition(1)))
      this.setDir('E')
      cellValues(startPosition(0) + 1)(startPosition(1)) = 'B'
    }
    else if (((startPosition(1) + 1) < cellValues.length) && (cellValues(startPosition(0))(startPosition(1) + 1) == '.')) {
      this.setPosition(Array[Int](startPosition(0), startPosition(1) + 1))
      this.setDir('S')
      cellValues(startPosition(0))(startPosition(1) + 1) = 'B'
    }
    else if (((startPosition(0) - 1) > -1) && (cellValues(startPosition(0) - 1)(startPosition(1)) == '.')) {
      this.setPosition(Array[Int](startPosition(0) - 1, startPosition(1)))
      this.setDir('W')
      cellValues(startPosition(0) - 1)(startPosition(1)) = 'B'
    }
    else if (((startPosition(1) - 1) > -1) && (cellValues(startPosition(0))(startPosition(1) - 1) == '.')) {
      this.setPosition(Array[Int](startPosition(0), startPosition(1) - 1))
      this.setDir('N')
      cellValues(startPosition(0))(startPosition(1) - 1) = 'B'
    }
    else return false
    true
  }
}

object Player {
  def main(args: Array[String]): Unit = {
    val in: Scanner =  new Scanner(System.in)
    val width: Int = in.nextInt()
    val height: Int = in.nextInt()
    val myId: Int = in.nextInt()
    if (in.hasNextLine) in.nextLine
    //CREATE AN ARRAY 2D TO MAP WIDTH,HEIGHT
    val cellValues = Array.ofDim[Char](width,height)
    for (i <- 0 until height) {
      val line = in.nextLine
      for (j <- 0 until width) {
        cellValues(j)(i) = line.charAt(j) //SET MAP


      }
    }
    //STARTING AT (0,0)
    var startX = 0
    var startY = 0
    var foundStart = false

    breakable {


      for (i <- 0 until height) {
        for (j <- 0 until width) {
          if (cellValues(i)(j) == '.') {
            startX = j
            startY = i
            foundStart = true
            break

          }
        }
        if (foundStart) break
      }
    }
    // Write an action using System.out.println()
    // To debug: System.err.println("Debug messages...");
    System.out.println(startX + " " + startY)
    val myShip = new Ship(Array[Int](startX, startY), ' ', myId)
    // game loop
    while ( {
      true
    }) {
      val x = in.nextInt
      val y = in.nextInt
      val myLife = in.nextInt
      val oppLife = in.nextInt
      val torpedoCooldown = in.nextInt
      val sonarCooldown = in.nextInt
      val silenceCooldown = in.nextInt
      val mineCooldown = in.nextInt
      val sonarResult = in.next
      if (in.hasNextLine) in.nextLine
      val opponentOrders = in.nextLine
      System.err.println(x)
      System.err.println(y)
      System.err.println(sonarResult)
      System.err.println(opponentOrders)
      //CHECK THE SHIP CAN MOVE
      //IF SHIP CAN MOVE GET DIRECTION
      def canMove: Boolean = myShip.move(cellValues)
      if (canMove) System.out.println("MOVE " + myShip.getDir + " TORPEDO")
      else { // surface mechanism
        for (i <- 0 until height) {
          for (j <- 0 until width) {
            if ((cellValues(j)(i) == 'B') && !(j == myShip.getPosition(0) && i == myShip.getPosition(1))) cellValues(j)(i) = '.'
          }
        }
        System.out.println("SURFACE")
      }

      System.err.println(myShip)
    }
  }
}
