//*Step 1: count characters in a string
function countingCharacters(stringToCount){
    console.log (stringToCount + " has " + 
              stringToCount.length + " characters.");
}

//*Step 2: counts s specific character in a string
function countingCharacters2(stringToCount, characterToFind){
    var characterCount = 0;
    for(var position = 0; position < stringToCount.length; position++) {
        if(stringToCount[position] == characterToFind) {
            characterCount++;
        }
    }
    console.log ("String to search in: " + stringToCount); //xxaxxxbxx
    console.log("Character to find: " + characterToFind); //x
    console.log("Number of times the character appears: " + characterCount); //7
}

//*Step 3: count a series of characters in a string
function countingCharacters3(str,search) {
    var count = 0;
    var numChars = search.length;
    var lastIndex = str.length - numChars;
    for(var index = 0; index <= lastIndex; index++){
        var current = str.substring(index, index + numChars);
        if (current == search){
            count++;
        }
    }
    return count; //4
}
    