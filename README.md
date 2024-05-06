<h2>Introduction</h2>

<p>This Project is a part of the technical assessment provided by dignitary</p>
<p>this documentation will go over how solving the coding challenges was approached</p>


<h3>1-String Calculation Function</h3>
<p>This problem is pretty straight forward we have a formula,
and we need to pass in a string to that formula to get an answer</p>

<p>first of all i started with a pretty simple scanner to read the user input and pass it to a method to calculate the formula's result</p>

<p>The challenge in this was, how do i obtain every single possible substring combination from the original user input</p>
<p> Well simple! just iterate over them with the start index being the first character in the string
and the last index in the inner loop pointing to the end of the substring, now that we have calculated every function for these combinations we move the outer loop to point to the second character in the string with every other end index possible after it, and so on</p>

<p>Finally, we have been storing the maximum value in a variable to hold it and comparing it with the new value if the new value is higher we just let the max variable hold it at the end we will have itterated through every single possible combination and calculated the formula for it, and through the max comparison now we have the maximum value and simply return it</p>

<h3>2-Library Fine</h3>
<p>This challenge requires us to calculate a fine that is required when a book is returned to the library after it's return due date</p>
<p>Usually we tackle these types of issues with Date Libraries but for this solution we will go with simple math</p>
<p>First of all we will read the input as java arguments, since i am using openJDK 16.0.1 i can utilize the single line run command provided in java 11+ where i don't have to compile my .java files into .class files before running i can simply do this by providing this command (java filename.java arguments) </p>
<p>then we read these arguments that have been provided, and we pass them to a function to calculate the fine based on the return date and due date (if any fine exist)</p>

<h3>3-Counter Game</h3>
<p>This game is a play on the power of 2, the first solution that would come to mind is taking the square root of a number then, 
checking if it is a whole number to determine whether it is a power of 2 or not </p>
<p>The problem could be tackled in this approach but this brings high complexity because we have to iterate over each number and calculate the square root for it, then checking if the result is a whole number</p>
<p>A more computationally realistic approach would be to check the binary representation of a number, for this we have 2 important rules: </p>

<h4>1-If a number is a power of 2, its binary representation will have only one bit set to 1. All other bits will be 0</h4>

<h4>2-If we perform a bitwise AND operation between the number and 1 it will result in 0 if and only if the number is a power of 2</h4>

<p>Based on this logic we take the input number then check if it is a 1 Ali wins based on the rules else, we check if it is a power of 2 by doing an AND with 1, if it's a power of 2 we divide it by 2 by shifting it 1 bit to the right, examples are shown in code comments</p>
<p>everytime we shift we increase a counter indicating the turn has moved between Nasser and Ali, because they are taking turns an odd turn number will always result in Nasser's win while an even turn number will cause in Ali's win unless, they start at 1 where Ali automatically wins</p>