import pt.isel.canvas.*

const val CANVAS_WIDTH = 20
const val CANVAS_HEIGHT = 16

//data class Game(val snake:Snake, val wall:List<Position>)
//data class Snake( )
//data class Position()

fun main() {
    onStart {
        /** Creation of the Canvas window and the first RoundSquare **/
        val cv = Canvas(650, 480, BLACK)
        cv.drawImage("snake.png",0,0)


    }
    onFinish {}
}
