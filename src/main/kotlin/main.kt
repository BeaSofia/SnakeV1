import pt.isel.canvas.*

const val CELL_SIDE = 32
const val GRID_WIDTH = 20
const val GRID_HEIGHT = 16
const val SPRITE_DIV = 64

data class Game(val snake:Snake, val wall: List<Position>)


fun Canvas.drawGrid(){
    (CELL_SIDE..height step CELL_SIDE).forEach{
        drawLine(0, it, width, it, WHITE,1)
    }
    (CELL_SIDE..width step CELL_SIDE).forEach {
        drawLine(it, 0, it, width, WHITE, 1)
    }
}


fun Canvas.drawGame(game: Game) {
    erase()
    drawGrid()
    drawHead(game.snake)
    drawTail(game.snake)
    drawWalls(game.wall)
}




fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH * CELL_SIDE, GRID_HEIGHT * CELL_SIDE, BLACK)
        var game = Game(Snake(Position(0, GRID_HEIGHT / 2),
            Position(-1, GRID_HEIGHT / 2), Direction.RIGHT), emptyList())
        cv.drawGame(game)



        cv.onKeyPressed { ke ->
            game = Game(newDirection(game.snake, ke.code),game.wall)

        }
        cv.onTimeProgress(500) {
            game = move(game)
            game = Game(Snake(game.snake.headPosition.normalize(), game.snake.tailPosition.normalize(),game.snake.direction), game.wall)
            cv.drawGame(game)
        }

        cv.onTimeProgress(5000){
            game = createWalls(game)
            cv.drawGame(game)
        }


    }
    onFinish { }
}