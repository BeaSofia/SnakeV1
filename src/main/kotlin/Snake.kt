import pt.isel.canvas.Canvas

/**
 * Represents the snake composed by head´s and tail's position and their direction
 * @property headPosition the position of the head
 * @property tailPosition the position of the tail
 * @property direction the direction of the snake
 */
data class Snake(val headPosition: Position, val tailPosition: Position, val direction: Direction)

/**
 * Draw the head of the Snake
 * @receiver where it will be draw
 * @param snake Snake to be draw
 */

fun Canvas.drawSnakeHead(snake: Snake) {

    val x = snake.headPosition.x * CELL_SIDE
    val y = snake.headPosition.y * CELL_SIDE


    val xImgHead = SPRITE_DIV * when (snake.direction) {
        Direction.UP, Direction.LEFT    -> 3
        Direction.RIGHT, Direction.DOWN -> 4

    }
    val yImgHead = SPRITE_DIV * when (snake.direction) {
        Direction.UP, Direction.RIGHT   -> 0
        Direction.DOWN, Direction.LEFT  -> 1

    }

     /**
      * The right snakeHead image for each direction
      */

    when(snake.direction){
        Direction.RIGHT -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV",
            x, y, CELL_SIDE,CELL_SIDE)
        Direction.LEFT  -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV",
            x, y, CELL_SIDE,CELL_SIDE)
        Direction.DOWN  -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV",
            x, y, CELL_SIDE,CELL_SIDE)
        Direction.UP    -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV",
            x, y, CELL_SIDE,CELL_SIDE)
    }
}


/**
 * Draw the Tail of the Snake
 * @receiver where it will be draw
 * @param snake Snake to be draw
 */


fun Canvas.drawSnakeTail(snake: Snake) {


    val xImgTail = SPRITE_DIV * when (snake.direction) {
        Direction.UP, Direction.LEFT        -> 3
        Direction.DOWN, Direction.RIGHT     -> 4

    }
    val yImgTail = SPRITE_DIV * when (snake.direction) {
        Direction.UP, Direction.RIGHT       -> 2
        Direction.DOWN, Direction.LEFT      -> 3

    }

    /**
     * Draws the snake with the right tail position
     */

    drawImage("Snake.png|$xImgTail,$yImgTail,$SPRITE_DIV,$SPRITE_DIV",
        imagePositionTail(snake).x * CELL_SIDE,
        imagePositionTail(snake).y * CELL_SIDE, CELL_SIDE,CELL_SIDE)
}

fun imagePositionTail(snake: Snake) = Position(snake.tailPosition.x, snake.tailPosition.y)

/**
 * The right snakeTail image for each direction
 */

fun tailPosition (s:Snake): Position = when(s.direction) {
    Direction.UP        -> Position(s.headPosition.x, s.headPosition.y + 1)
    Direction.DOWN      -> Position(s.headPosition.x, s.headPosition.y - 1)
    Direction.RIGHT     -> Position(s.headPosition.x - 1, s.headPosition.y)
    Direction.LEFT      -> Position(s.headPosition.x + 1, s.headPosition.y)
}


