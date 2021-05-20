import pt.isel.canvas.Canvas

fun createWalls(game: Game) = Game(game.snake, wall = game.wall + posWalls())

fun Canvas.drawWalls (wall: List<Position>) = wall.forEach { drawImage("bricks.png", it.x, it.y, CELL_SIDE, CELL_SIDE) }

fun randomX() = (0..GRID_WIDTH).random()
fun randomY() = (0..GRID_HEIGHT).random()







