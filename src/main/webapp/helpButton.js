let popupFunction = () => {
    // Useful GitHub Copilot suggestion
    // let popup = document.getElementById("popup");
    // popup.classList.toggle("show");
    alert("Players take turns removing objects from the piles. On each turn, a player must remove at least one object, and may remove any number of objects provided they all come from the same pile. The goal of the game is to be the player to remove the last object. The player who removes the last object loses the game. Players should strategize and plan their moves in order to force their opponent to take the last object.");
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}