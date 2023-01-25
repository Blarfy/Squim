let gameBoard = [
    [true],
    [true,true,true],
    [true,true,true,true,true],
    [true,true,true,true,true,true,true]
]
let selectedRow;
const startGame = () => {
    for (let index = 0; index < gameBoard.length; index++) {
        let string = "r" + (index + 1)
        for (let jindex = 0; jindex < gameBoard[index].length; jindex++) {
            let num = getRandomInt(1, 7);
            let dwayne = `<div class="Dwayne" id="${index}-${jindex}"><img src="resources/Dwayne${num}.png" onclick="dwayneClick(${index}, ${jindex})"/></div>`;
            document.getElementById(`r${index+1}`).innerHTML += dwayne;
        }
    }
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
        } else {
            dwayne.style.filter = "brightness(50%)";
            gameBoard[index][jindex] = false;
        }
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
    selectedRow = null;
    for (let index = gameBoard.length - 1; index >= 0; index--) {
        for (let jindex = gameBoard[index].length - 1; jindex >= 0; jindex--) {
            let dwayne = document.getElementById(`${index}-${jindex}`);
            if (gameBoard[index][jindex] == false) {
                dwayne.style.visibility = "hidden"
                console.log("removed")
                console.log(gameBoard[index].slice(jindex))
                gameBoard[index][jindex] = null;
            }
        }
    }
    console.log(gameBoard);
}

window.onload = () => {
    startGame();
}