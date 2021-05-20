import pt.isel.canvas.Canvas


data class Snake(val headPosition: Position, val tailPosition: Position, val direction: Direction)


fun Canvas.drawHead(snake: Snake) {

    val x = snake.headPosition.x * CELL_SIDE
    val y = snake.headPosition.y * CELL_SIDE


    val xImgHead = SPRITE_DIV * when (snake.direction) {
        Direction.UP, Direction.LEFT -> 3
        Direction.RIGHT, Direction.DOWN -> 4

    }
    val yImgHead = SPRITE_DIV * when (snake.direction) {
        Direction.UP, Direction.RIGHT -> 0
        Direction.DOWN, Direction.LEFT -> 1

    }

    val head = when(snake.direction){
        Direction.RIGHT -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV", x, y, CELL_SIDE,CELL_SIDE)
        Direction.LEFT -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV", x, y, CELL_SIDE,CELL_SIDE)
        Direction.DOWN -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV", x, y, CELL_SIDE,CELL_SIDE)
        Direction.UP -> drawImage("Snake.png|$xImgHead,$yImgHead,$SPRITE_DIV,$SPRITE_DIV", x, y, CELL_SIDE,CELL_SIDE)
    }
    println("cabeça = ${snake.headPosition}")
}


    fun Canvas.drawTail(snake: Snake) {
        val x = snake.tailPosition.x * CELL_SIDE
        val y = snake.tailPosition.y * CELL_SIDE


        val xImgTail = SPRITE_DIV * when (snake.direction) {
            Direction.UP, Direction.LEFT -> 3
            Direction.DOWN, Direction.RIGHT -> 4

        }
        val yImgTail = SPRITE_DIV * when (snake.direction) {
            Direction.UP, Direction.RIGHT -> 2
            Direction.DOWN, Direction.LEFT -> 3

        }

        //está errado

        when (snake.direction) {
            Direction.RIGHT -> drawImage("Snake.png|$xImgTail,$yImgTail,$SPRITE_DIV,$SPRITE_DIV",
                x - CELL_SIDE, y, CELL_SIDE, CELL_SIDE
            )
            Direction.LEFT -> drawImage("Snake.png|$xImgTail,$yImgTail,$SPRITE_DIV,$SPRITE_DIV",
                x + CELL_SIDE, y, CELL_SIDE, CELL_SIDE
            )
            Direction.DOWN -> drawImage("Snake.png|$xImgTail,$yImgTail,$SPRITE_DIV,$SPRITE_DIV", x,
                y - CELL_SIDE, CELL_SIDE, CELL_SIDE
            )
            Direction.UP -> drawImage("Snake.png|$xImgTail,$yImgTail,$SPRITE_DIV,$SPRITE_DIV", x,
                y + CELL_SIDE, CELL_SIDE, CELL_SIDE
            )
        }

        println("cauda = ${snake.tailPosition}")
    }

