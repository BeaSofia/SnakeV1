import pt.isel.canvas.Canvas

/**
 * Adds to the list of walls, initially empty, the walls that are drawn
 */
fun createWalls(game: Game) = Game(game.snake, wall = game.wall + validWallPosition(game))


/**
 * Draws all the walls of the game
 * @receiver where it will be drawn
 * @param wall the wall information
 */
fun Canvas.drawWalls (wall: List<Position>) = wall.forEach { drawImage("bricks.png", it.x * CELL_SIDE,
    it.y *CELL_SIDE, CELL_SIDE, CELL_SIDE) }


/**
 * All positions available in the game
 */
val ALL_POSITIONS :List<Position> = (0 until GRID_HEIGHT*GRID_WIDTH).map {Position(it%GRID_WIDTH, it/GRID_WIDTH)}


/**
 * Remove from the list of ALL_POSITIONS, the positions of the walls in game,
 * rearrange the positions randomly and choose the first one that is not equal to the current position of the snake
 */
fun validWallPosition(game:Game): Position {
    val validPosition = (ALL_POSITIONS - game.wall).shuffled().first { it != game.snake.headPosition.normalize()
            && it != game.snake.tailPosition.normalize()}
    return Position(validPosition.x , validPosition.y)
}





