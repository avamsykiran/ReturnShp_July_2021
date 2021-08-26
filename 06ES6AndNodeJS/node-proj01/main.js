console.log("Hello World! This is Javascript(ES6)")

let str = `This is a a long string
            this multi line string 
            `;

console.log(str);

let userName ="Vamsy";
let age = 35;

//let str2 = "Hello " + userName + "! you are " + age + " years old";
let str2 = `Hello ${userName}! You are ${age} years old`; //template literals
console.log(str2);

console.log(str2.toLowerCase())
console.log(str2.toUpperCase())
console.log(str2.substr(3,10));
console.log(str2.substring(3,10));
console.log(str2.length);

console.log(Math.round(Math.PI))
console.log(Math.floor(Math.PI))
console.log(Math.ceil(Math.PI))

let d = new Date();
console.log(d);
console.log(d.toLocaleDateString())
console.log(d.toTimeString())
console.log(d.toDateString())
console.log(d.toISOString())
