var testArray = [];
var sum = 0; 

<!--I started i at 1 so that the prompt starts counting from 1 instead of 0 so that the user know that they are entering 5 numbers-->
for(let i = 1; i<6; i++) {
        newElement = prompt(i+". " + "Enter a number of your choice:");
 <!--the 2 lines must be placed in the {} to work properly, otherwise the loop only adds the number from the first prompt. Yet again order is important!-->
    
        newElement = parseInt(newElement);
        testArray.push(newElement);
}
for (var position =0; position< testArray.length; position++) {
    sum += testArray[position];
}
console.log("The sum of " + testArray + " is: " +sum); 
