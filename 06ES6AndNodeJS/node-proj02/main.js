import { runArraysDemo } from "./arraysDemo.js";
import { functionsDemo } from "./functionsDemo.js";
import { v1, v2, v3 } from './moduleDummy.js';
import v from './moduleDummy.js';
import { Employee, Manager } from './oopDemo.js';

functionsDemo();
runArraysDemo();

console.log(v1);
console.log(v2);
console.log(v3);
console.log(v);

let e = new Employee(101, "Vamsy", "Aripaka", 54000);
let m = new Manager(102, "Suseela", "Aripaka", 154000, 8900);
console.log(e);
console.log(m);

let e1;
let e2 = null;
console.log(e1);
console.log(e2);

if (e)
    console.log("e is good");
else
    console.log("e is bad");

if (e1)
    console.log("e1 is good");
else
    console.log("e1 is bad");

if (e2)
    console.log("e2 is good");
else
    console.log("e2 is bad");

console.log(e || e1);
console.log(e && e1);

function f(){
    if(true){
        var x=90;
        console.log(x);
        let y=100;
        console.log(y);
    }
    console.log(x);
    //console.log(y); is not possible 
}

f();
