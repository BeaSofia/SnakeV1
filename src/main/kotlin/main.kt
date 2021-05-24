import pt.isel.canvas.*

/**
 * The main function of the game
 */

fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH * CELL_SIDE, GRID_HEIGHT * CELL_SIDE, BLACK)
        var game = Game(Snake(Position(5, GRID_HEIGHT / 2),
            Position(4, GRID_HEIGHT / 2), Direction.RIGHT), emptyList())
        cv.drawGame(game)


        cv.onKeyPressed { ke ->
            game = Game(newDirection(game.snake, ke.code),game.wall)
        }

        cv.onTimeProgress(250) {
            game = if (isSnakeColliding(game)) game  else move(game)
            cv.drawGame(game)
            game = Game(game.snake.copy(tailPosition = tailPosition(game.snake)),game.wall)
            game = Game(Snake(
                    game.snake.headPosition.normalize(),
                    game.snake.tailPosition.normalize(),
                    game.snake.direction), game.wall)


        }

        cv.onTimeProgress(5000){
            game = createWalls(game)
            cv.drawGame(game)
        }

    }
    onFinish { }
}


