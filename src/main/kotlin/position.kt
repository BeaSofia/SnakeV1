import pt.isel.canvas.*

data class Position(val x: Int, val y: Int)
enum class Direction (val dx: Int, val dy: Int){
    LEFT(-1,0), UP(0,-1), RIGHT(1,0), DOWN(0,1)
}

fun Position.normalize():Position = when {
    x < 0               -> Position(GRID_WIDTH-1,y )
    x >= GRID_WIDTH     -> Position(0,y)
    y < 0               -> Position(x, GRID_HEIGHT -1)
    y >= GRID_HEIGHT    -> Position(x, 0)
    else -> this
}

fun newDirection(s: Snake, ke: Int): Snake {
    return when  {
        ke == UP_CODE && s.direction != Direction.DOWN -> s.copy(direction  = Direction.UP)
        ke == DOWN_CODE && s.direction != Direction.UP -> s.copy(direction  = Direction.DOWN)
        ke == LEFT_CODE && s.direction != Direction.RIGHT -> s.copy(direction  = Direction.LEFT)
        ke == RIGHT_CODE && s.direction != Direction.LEFT -> s.copy(direction  = Direction.RIGHT)
        else -> s
    }
}

fun move (game: Game)=Game(Snake(Position(game.snake.headPosition.x + game.snake.direction.dx,
    game.snake.headPosition.y + game.snake.direction.dy),Position(game.snake.tailPosition.x + game.snake.direction.dx,
    game.snake.tailPosition.y + game.snake.direction.dy), game.snake.direction), game.wall)


fun posWalls(): Position = Position(randomX()*CELL_SIDE, randomY()*CELL_SIDE)