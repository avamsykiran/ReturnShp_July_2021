
export class Employee {

    constructor(id,firstName,lastName,salary){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
        this.designation="Associate";
    }

    getTa(){
        return this.salary*0.10;
    }

    getNetPay(){
        return this.salary+this.getTa();
    }
}

export class Manager extends Employee {
    constructor(id,firstName,lastName,salary,allowence){
        super(id,firstName,lastName,salary);
        this.designation="Manager";
        this.allowence=allowence;
    }
    
    getNetPay(){
        return this.salary+this.getTa()+this.allowence;
    }
}