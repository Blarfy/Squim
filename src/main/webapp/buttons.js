const pvpButton = document.getElementById("pvp");
let pvpButtonPressed = false;
const easyModo = document.getElementById("ez");
let easyModoPressed = false;
const meat = document.getElementById("meaty");
let meatyPressed = false;
const hardDK = document.getElementById("hardDK");
let hardDKPressed = false;

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
    } else {
        hardDK.style.backgroundColor = "#4593ff";
    }
}






// const popupFunction = () => {
//     // Useful GitHub Copilot suggestion
//     // let popup = document.getElementById("popup");
//     // popup.classList.toggle("show");
//     alert("Hello World! Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam enim eos dolor iusto, in minus quasi consectetur qui nobis voluptatum necessitatibus saepe. In eligendi, cumque eaque maiores molestiae quod deleniti? This will be replaced with a real in-page popup");
// }

// //unfinished
// const updateGame = async () => {
//     const response = await fetch("http://127.0.0.1:8080/updateGame", {
//         method: "PUT",
//         headers: {
//             "Content-Type": "cookie???"
//         },
//         body: document.cookie// GAME COOKIE
//     });
// }