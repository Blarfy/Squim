let gameBoard;
let totalDwaynes = 16;
let selectedRow;
let selectedCount = 0;
let turnCount = 0;
let playerHeader = document.getElementById("playerHeader");
let endTurnButton = document.getElementById("endTurnButton");
let gameArea = document.getElementById("gameArea");
let players = [];
let difficulty;
let isPVP;
let failChance;
const startGame = () => {
    gameBoard = [
                    [true],
                [true,true,true],
            [true,true,true,true,true],
        [true,true,true,true,true,true,true]
    ]
    for (let index = 0; index < gameBoard.length; index++) {
        let string = "r" + (index + 1)
        for (let jindex = 0; jindex < gameBoard[index].length; jindex++) {
            let num = getRandomInt(1, 7);
            let dwayne = `<div class="Dwayne" id="${index}-${jindex}"><img src="resources/Dwayne${num}.png" onclick="dwayneClick(${index}, ${jindex})"/></div>`;
            document.getElementById(`r${index+1}`).innerHTML += dwayne;
        }
    }
    players[0] = localStorage.getItem("player1Name");
    players[1] = localStorage.getItem("player2Name");
    isPVP = localStorage.getItem("pvp");
    difficulty = localStorage.getItem("difficulty");
    switch (difficulty) {
        case 1:
            failChance = .5;
            break;
        case 2:
            failChance = .3;
            break;
        case 3:
            failChance = .1;
            break;
    }
    playerHeader.innerHTML = players[0] + "'s Turn";
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

const dwayneClick = (index, jindex) => {
    dwayne = document.getElementById(`${index}-${jindex}`);
    //check is slected row is null
    if (selectedRow == null) {
        selectedRow = index;
    } else if (checkRowEmpty(gameBoard[selectedRow])) {
        selectedRow = index;
    }
    if (index == selectedRow) {
        if (dwayne.style.filter == "brightness(50%)") {
            dwayne.style.filter = "brightness(100%)";
            gameBoard[index][jindex] = true;
            selectedCount--;
        } else if (selectedCount < 2) {
            dwayne.style.filter = "brightness(50%)";
            gameBoard[index][jindex] = false;
            selectedCount++;
        }
    }
    if (selectedCount > 0) {
        endTurnButton.style.display = "block";
    } else {
        endTurnButton.style.display = "none";
    }
}

const checkRowEmpty = (row) => {
    let isFound = false;
    for (let index = 0; index < row.length; index++) {
        if (row[index] == false) {
            isFound = true;
        }
    }
    return !isFound;
}

const endTurn = () => {
    if (selectedCount > 0) {
        selectedRow = null;
        for (let index = gameBoard.length - 1; index >= 0; index--) {
            for (let jindex = gameBoard[index].length - 1; jindex >= 0; jindex--) {
                let dwayne = document.getElementById(`${index}-${jindex}`);
                if (gameBoard[index][jindex] == false) {
                    dwayne.style.visibility = "hidden"
                    gameBoard[index][jindex] = null;
                    console.log(`${players[turnCount % 2]}: removed - ${index} - ${jindex}`)
                    totalDwaynes--;
                }
            }
        }
        console.log(gameBoard);
        selectedCount = 0;
        turnCount++;
        playerHeader.innerHTML = players[turnCount % 2] + "'s Turn";
    } else {
        alert(`${players[turnCount % 2]}: You must select at least one Dwayne to remove`);
    }
    if (totalDwaynes == 0) {
        playerHeader.innerHTML = `Game Over`;
        gameArea.classList.add("flexBox");
        html = `<h1>${players[turnCount % 2]} wins!</h1> <div class="niceButton" id="playAgain"><a href="options.html">Play Again</a></div>`;
        gameArea.innerHTML = html;
    }
    if (isPVP == "false" && turnCount % 2 == 1) {
        aiTurn(failChance);
    }
    endTurnButton.style.display = "none";
}

window.onload = () => {
    startGame();
}



const aiTurn = (failChance) => {
    let oddOnes = false;
    let oddTwos = false;
    let oddFours = false;

    //check if total rocks is lower than 5
    var totalRocks = 0;
    //for each row in rows
    for (let index = 0; index < gameBoard.length; index++) {
        totalRocks += getCount(index);
    }

    //maybe put failchance here as well if endgame is too difficult for user
    if(totalRocks > 5) {

        //get random number between 0 and 1 and compare with failchance
        if (Math.random() < failChance) {
            for (let index = 0; index < gameBoard.length; index++) {
                var tempCount = getCount(index);
                if (getCount(index) % 2 == 1) {
                    oddOnes = !oddOnes;
                    tempCount--;
                }
                while (tempCount >= 4) {
                    oddFours = !oddFours;
                    tempCount -= 4;
                }
                while (tempCount >= 2) {
                    oddTwos = !oddTwos;
                    tempCount -= 2;
                }
            }
        } else console.log("Failed to calculate odds!");

        if (oddOnes) {
            for (let index = 0; index < gameBoard.length; index++) {
                if (getCount(index) >= 1) {
                    // take one
                    aiDeleteRock(index, 1);
                    console.log("Player took 1 from row " + index);
                    break;
                }
            }
        } else if (oddTwos) {
            for (let index = 0; index < gameBoard.length; index++) {
                if (getCount(index) >= 2) {
                    // take two
                    aiDeleteRock(index, 2);
                    console.log("Player took 2 from row " + index);
                    break;
                }
            }
        } else if (oddFours) {
            for (let index = 0; index < gameBoard.length; index++) {
                if (getCount(index) >= 4) {
                    // take two
                    aiDeleteRock(index, 2);
                    console.log("Player took 4 from row " + index);
                    break;
                }
            }
        } else {
            var randMove = false;
            while (!randMove) {
                var randRow = Math.floor(Math.random() * gameBoard.length);
                if (getCount(randRow) % 2 == 1 || getCount(randRow) == 2) {
                    aiDeleteRock(randRow, 1);
                    console.log(gameBoard)
                    console.log(selectedCount)
                    console.log("Player took 1 from row " + randRow);
                    randMove = true;
                } else if (getCount(randRow) > 2) {
                    aiDeleteRock(randRow, 2);
                    console.log("Player took 2 from row " + randRow);
                    randMove = true;
                }
            }
        }
    } else {
        for (let index = 0; index < gameBoard.length; index++) {
            if (getCount(index) >= 2) {
                // take one
                aiDeleteRock(index, 1);
                console.log("Player took 2 from row " + index);
                break;
            } else if (getCount(index) == 1) {
                // if it cannot be helped, accept defeat
                aiDeleteRock(index, 1);
                console.log("Player took 1 from row " + index);
                break;
            }
        }
    }
    if (selectedCount > 0) {
        endTurn();
    }
}

const getCount = (row) => {
    var count = 0;
    for (let index = 0; index < gameBoard[row].length; index++) {
        if (gameBoard[row][index] == true) {
            count++;
        }
    }
    return count;
}

const aiDeleteRock = (row, count) => {
    for (let index = 0; index < gameBoard[row].length; index++) {
        stringy = ""
        gameBoard[row].forEach(element => {
            stringy += element + " ";
        });
        console.log(stringy)
        if (gameBoard[row][index] == true) {
            gameBoard[row][index] = false;
            selectedCount++;
            count--;
            console.log(gameBoard)
        }
        if (count == 0) {
            break;
        }
    }
}