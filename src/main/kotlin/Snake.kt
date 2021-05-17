import pt.isel.canvas.*


fun Canvas.drawSnake(snake: Snake){
    val x = snake.position.x * CELL_SIDE - snake.animation * snake.vector.dx()
    val y = snake.position.y * CELL_SIDE - snake.animation * snake.vector.dy()

    drawImage("snake.png|192,0,64,64", x, y, CELL_SIDE, CELL_SIDE)
    //val dirImage =
}