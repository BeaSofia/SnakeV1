import pt.isel.canvas.*

const val CELL_SIDE = 64
const val CANVAS_WIDTH = 20
const val CANVAS_HEIGHT = 16

//data class Game(val snake:Snake, val wall:List<Position>)
data class Snake(val position:Position, val animation:Int, val vector:Direction? )
data class Position(val x:Int, val y: Int)
operator fun Position.plus( direction:Direction ) = Position( x + direction.dx(), y + direction.dy() )
enum class Direction(val dx:Int, val dy:Int) { LEFT(-1,0), UP(0,-1), RIGHT(1,0), DOWN(0,1) }

fun Direction?.dx() = this?.dx ?: 0
fun Direction?.dy() = this?.dy ?: 0

fun Canvas.drawGrid() {
    (CELL_SIDE..height step CELL_SIDE).forEach {
        drawLine(0, it, width, it, WHITE, 1) // horizontal
    }
    (CELL_SIDE..width step CELL_SIDE).forEach {
        drawLine(it, 0, it, height, WHITE, 1) // vertical
    }
}
fun Canvas.drawArena(snake:Snake) {
    erase()
    drawGrid()
    drawSnake(snake)
}

fun directionMov(key: Int) :Direction? = when(key){
    LEFT_CODE -> Direction.LEFT
    RIGHT_CODE -> Direction.RIGHT
    UP_CODE -> Direction.UP
    DOWN_CODE -> Direction.DOWN
    else -> null
}
fun movement(key: Int, snake:Snake) :Snake{
    val direction = directionMov(key) ?: return snake
    val toPosition = snake.position + direction
    return Snake(toPosition,CELL_SIDE,direction)
   // return if (toPosition.isValid)
}

fun main() {
    onStart {
        /** Creation of the Canvas window and the first RoundSquare **/
        val cv = Canvas(20*64, 16*64, BLACK)
        var snake = Snake( Position(CANVAS_WIDTH/2, CANVAS_HEIGHT/2), animation = 0, null)
        cv.drawArena(snake)

        cv.onKeyPressed { ke :KeyEvent ->
            snake = movement(ke.code,snake)
            cv.drawArena(snake) }
      /* cv.onTimeProgress(15){

        }
        cv.onTimeProgress(250){
            //aparecem brincs aleatóriamente
        } */
    }
    onFinish {}
}
