
function f1(){
    console.log("this is a normal fucntion")
}

const f2 = function(){
    console.log("this is an anonymous function assigend to a varible")
}

const f3 = () => console.log("This is an arrow function")

const f4 = function(operation){
    let fn=null;
    switch(operation){
        case 'sum':fn= (n1,n2) => n1+n2; break;
        case 'dif':fn= (n1,n2) => n1-n2; break;
        case 'prd':fn= (n1,n2) => n1*n2; break;
        case 'qut':fn= (n1,n2) => n1/n2; break;
    }
    return fn;
}

const greet=(greeter,userName) => {
    if(typeof greeter === 'string')
        console.log(`${greeter} ${userName}`);
    else if(typeof greeter === 'function')
        console.log(`${greeter()} ${userName}`);
    else
        throw "Invalid greeter";
};

export function functionsDemo(){
    console.log("Functions Demo");
    
    f1();
    f2();
    f3();

    console.log(f4('sum')(10,5));
    console.log(f4('dif')(10,5));
    console.log(f4('prd')(10,5));
    console.log(f4('qut')(10,5));
 
    const s = f4('sum');
    const d = f4('dif');
    const p = f4('prd');
    const q = f4('qut');

    console.log(s(20,10));
    console.log(d(20,10));
    console.log(p(20,10));
    console.log(q(20,10));

    console.log(greet("Hello","Vamsy"))
    console.log(greet(() => "Namsthey","Vamsy"))

    const timlyGreeter = () => {
        let h = new Date().getHours();
        let s = "";
        if(h>=3 && h<11) s = "Good Morning";
        else if(h>=11 && h<=16 ) s="Good Noon";
        else s="Good Evening";
        return s;
    };

    console.log(greet(timlyGreeter,"Vamsy"));
}