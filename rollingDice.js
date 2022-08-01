
//*dice with n-sides

var numSides = prompt("How many sides does the die have?");
var timesRoll =prompt("How many time do you want to roll the die?")

function rollDice(numSides) {
    return Math.floor(Math.random() * numSides) +1;
}
for (var i = 0; i < timesRoll; i++){
console.log(rollDice(numSides));
}