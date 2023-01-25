const startGame = () => {
    game = {
        "gameId": 1,
        "rows": [
                    [true],
                    [true,true,true],
                    [true,true,true,true,true],
                    [true,true,true,true,true,true,true]
                ],
        "players": ["Player 1", "Player 2"],
    }
    for (let index = 0; index < game.rows.length; index++) {
        let string = "r" + (index + 1)
        for (let jindex = 0; jindex < game.rows[index].length; jindex++) {
            let num = getRandomInt(1, 7);
            let dwayne = `<div class="Dwayne" id="${index}-${jindex}"><img src="resources/Dwayne${num}.png" /></div>`;
            document.getElementById(`r${index+1}`).innerHTML += dwayne;
        }
        
        
    }
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

window.onload = () => {
    startGame();
}