let popupFunction = () => {
    // Useful GitHub Copilot suggestion
    // let popup = document.getElementById("popup");
    // popup.classList.toggle("show");
    alert("Click on a Dwayne to select him for removal. You can only select up to 2 Dwaynes per turn. Click the 'End Turn' button to remove the selected Dwaynes. Players take turns doing this, the game ends when all Dwaynes are removed. Good luck!");
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}