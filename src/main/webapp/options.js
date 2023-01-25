const pvpButton = document.getElementById("pvp");
let pvpButtonPressed = false;
const easyModo = document.getElementById("ez");
let easyModoPressed = false;
const meat = document.getElementById("meaty");
let meatyPressed = false;
const hardDK = document.getElementById("hardDK");
let hardDKPressed = false;
const player2NameBox = document.getElementById("player2NameBox");
let playNowButton = document.getElementById("playButton");

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
        playNowButton.style.display = "block";
    } else {
        pvpButton.style.backgroundColor = "#4593ff";
        player2NameBox.style.display = "none";
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
        playNowButton.style.display = "block";
    } else {
        easyModo.style.backgroundColor = "#4593ff";
        playNowButton.style.display = "none";
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
        playNowButton.style.display = "block";
    } else {
        meat.style.backgroundColor = "#4593ff";
        playNowButton.style.display = "none";
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
        playNowButton.style.display = "block";
    } else {
        hardDK.style.backgroundColor = "#4593ff";
        playNowButton.style.display = "none";
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

const dataPass = () => {
    if (pvpButtonPressed) {
        if (player1NameValue == "" || player2NameValue == "") {
            alert("Please enter a name for both players");
        } else {
            localStorage.setItem("player1Name", player1NameValue);
            localStorage.setItem("player2Name", player2NameValue);
            localStorage.setItem("pvp", true);
        }
    } else if (easyModoPressed) {
        localStorage.setItem("player1Name", player1NameValue);
        localStorage.setItem("player2Name", "Schmitty Werbenjagermanjensen");
        localStorage.setItem("pvp", false);
        localStorage.setItem("difficulty", 1);
    } else if (meatyPressed) {
        localStorage.setItem("player1Name", player1NameValue);
        localStorage.setItem("player2Name", "Bobby Tables");
        localStorage.setItem("pvp", false);
        localStorage.setItem("difficulty", 2);
    } else if (hardDKPressed) {
        localStorage.setItem("player1Name", player1NameValue);
        localStorage.setItem("player2Name", "Leeroy Jenkins");
        localStorage.setItem("pvp", false);
        localStorage.setItem("difficulty", 3);
    } else {
        alert("Please select a game mode");
    }
}