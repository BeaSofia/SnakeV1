import pt.isel.canvas.*

const val CELL_SIDE = 32
const val GRID_WIDTH = 20
const val GRID_HEIGHT = 16
const val SPRITE_DIV = 64

/**
 * Represents the game composed by the snake and the walls
 * @property snake the snake in game
 * @property wall the list of all walls in the game
 */

data class Game(val snake:Snake, val wall: List<Position>)


/*
* Create the grid of the game


fun Canvas.drawGrid(){
    (CELL_SIDE..height step CELL_SIDE).forEach{
        drawLine(0, it, width, it, WHITE,1)
    }
    (CELL_SIDE..width step CELL_SIDE).forEach {
        drawLine(it, 0, it, width, WHITE, 1)
    }
}*/

/**
 * Draws the entire area of the game: Snake(head and tail), Walls
 */
fun Canvas.drawGame(game: Game) {
    erase()
    //drawGrid()
    drawSnakeHead(game.snake)
    drawSnakeTail(game.snake)
    drawWalls(game.wall)
}