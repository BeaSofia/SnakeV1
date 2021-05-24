import pt.isel.canvas.*


/**
 * Represents a position in a two-dimensional space
 * @property x value from 0 to the maximum width of the space
 * @property y value from 0 to the maximum height of the space
 */
data class Position(val x: Int, val y: Int)

/**
 * All the possible directions
 *
 * @property dx X-axis offset of the direction
 * @property dy Y-axis offset of the direction
 */
enum class Direction (val dx: Int, val dy: Int){
    LEFT(-1,0), UP(0,-1), RIGHT(1,0), DOWN(0,1)
}


/**
 * Verify if the position is within the limits of the game and, if not, return the correct position
 */
fun Position.normalize():Position = when {
    x <0                    -> Position(GRID_WIDTH-1,y )
    x >= GRID_WIDTH         -> Position(0,y)
    y <0                    -> Position(x, GRID_HEIGHT -1)
    y >= GRID_HEIGHT        -> Position(x, 0)
    else -> this
}

/**
 * Verifies if the snake collides with the wall according to snake's direction
 */
fun collision (snake: Snake, wall:Position) = when (snake.direction){
    Direction.RIGHT -> snake.headPosition.x  == wall.x - 1 && snake.headPosition.y == wall.y
    Direction.LEFT  -> snake.headPosition.x  == wall.x + 1 && snake.headPosition.y  == wall.y
    Direction.DOWN  -> snake.headPosition.x  == wall.x && snake.headPosition.y  == wall.y - 1
    Direction.UP    -> snake.headPosition.x  == wall.x && snake.headPosition.y == wall.y + 1
}

/**
 * Returns true when the snake collides with any wall
 */

fun isSnakeColliding(game: Game):Boolean = game.wall.any{collision(game.snake, it)}

/**
 *  Returns the direction associated with the indicated key.
 *  @param s The snake
 *  @param ke The key code
 *  @return Snake associated with the key
 */

fun newDirection(s: Snake, ke: Int): Snake {
    return when {
        ke == UP_CODE && s.direction != Direction.DOWN      -> s.copy(direction  = Direction.UP)
        ke == DOWN_CODE && s.direction != Direction.UP      -> s.copy(direction  = Direction.DOWN)
        ke == LEFT_CODE && s.direction != Direction.RIGHT   -> s.copy(direction  = Direction.LEFT)
        ke == RIGHT_CODE && s.direction != Direction.LEFT   -> s.copy(direction  = Direction.RIGHT)
        else -> s
    }
}

/**
 * Performs the movement of the snake in the game
 */
fun move (game: Game)=Game(Snake(Position(game.snake.headPosition.x + game.snake.direction.dx,
    game.snake.headPosition.y + game.snake.direction.dy),
    Position(game.snake.tailPosition.x + game.snake.direction.dx,
    game.snake.tailPosition.y + game.snake.direction.dy), game.snake.direction), game.wall)



