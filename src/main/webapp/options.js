const pvpButton = document.getElementById("pvp");
let pvpButtonPressed = false;
const easyModo = document.getElementById("ez");
let easyModoPressed = false;
const meat = document.getElementById("meaty");
let meatyPressed = false;
const hardDK = document.getElementById("hardDK");
let hardDKPressed = false;
const player2NameBox = document.getElementById("player2NameBox");

//onclick for pvp button
pvpButton.onclick = () => {
    pvpButtonPressed = !pvpButtonPressed;
    if (pvpButtonPressed) {
        pvpButton.style.backgroundColor = "#2d19c6";
        easyModoPressed = false;
        easyModo.style.backgroundColor = "#4593ff";
        meatyPressed = false;
        meat.style.backgroundColor = "#4593ff";
        hardDKPressed = false;
        hardDK.style.backgroundColor = "#4593ff";
        player2NameBox.style.display = "block";
    } else {
        pvpButton.style.backgroundColor = "#4593ff";
    }
}

//onclick for easy button
easyModo.onclick = () => {
    easyModoPressed = !easyModoPressed;
    if (easyModoPressed) {
        easyModo.style.backgroundColor = "#2d19c6";
        meatyPressed = false;
        meat.style.backgroundColor = "#4593ff";
        hardDKPressed = false;
        hardDK.style.backgroundColor = "#4593ff";
        pvpButtonPressed = false;
        pvpButton.style.backgroundColor = "#4593ff";
        player2NameBox.style.display = "none";
    } else {
        easyModo.style.backgroundColor = "#4593ff";
    }
}

//onclick for meaty button
meat.onclick = () => {
    meatyPressed = !meatyPressed;
    if (meatyPressed) {
        meat.style.backgroundColor = "#2d19c6";
        easyModoPressed = false;
        easyModo.style.backgroundColor = "#4593ff";
        hardDKPressed = false;
        hardDK.style.backgroundColor = "#4593ff";
        pvpButtonPressed = false;
        pvpButton.style.backgroundColor = "#4593ff";
        player2NameBox.style.display = "none";
    } else {
        meat.style.backgroundColor = "#4593ff";
    }
}

//onclick for hardDK button
hardDK.onclick = () => {
    hardDKPressed = !hardDKPressed;
    if (hardDKPressed) {
        hardDK.style.backgroundColor = "#2d19c6";
        easyModoPressed = false;
        easyModo.style.backgroundColor = "#4593ff";
        meatyPressed = false;
        meat.style.backgroundColor = "#4593ff";
        pvpButtonPressed = false;
        pvpButton.style.backgroundColor = "#4593ff";
        player2NameBox.style.display = "none";
    } else {
        hardDK.style.backgroundColor = "#4593ff";
    }
}

const player1Name = document.getElementById("player1");
let player1NameValue = player1Name.value;
const player2Name = document.getElementById("player2");
let player2NameValue = player2Name.value;

player1Name.onkeyup = () => {
    player1NameValue = player1Name.value;
}

player2Name.onkeyup = () => {
    player2NameValue = player2Name.value;
}