
export function runArraysDemo(){
    console.log("Arrays Demo")

    let array1 = ["Vamsy","Kiran","suseela","Indhikaa"];
    console.log(array1);

    array1.push("Sagar");
    array1.push("Komal");
    console.log(array1);

    array1.pop()
    console.log(array1);

    array1.splice(3,2);
    console.log(array1);

    console.log(array1.find( s => s.length===5));
    console.log(array1.findIndex( s => s.length===5));
    console.log(array1.filter( s => s.length===5));
    console.log(array1.map( s => s.toUpperCase()));
    console.log(array1.reduce( (s1,s2) => s1>s2?s1:s2 ));
    array1.forEach(s => console.log(s));
    console.log(array1.sort())
    
}