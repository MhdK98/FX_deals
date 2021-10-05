export class FxModel {

}
export class loginUser{
    username:string;
    password:string;
    constructor(){
        this.username = "";
        this.password = "";
    }
}

export class FXrequest{
    user_id: Number;
    from_currency: Number;
    to_currency: Number;
    amount: Number;
    username: string;
}

export class UserInfo{
    user_id: Number;
    user_name: string;
    user_pass: string;
}

export class Currency{
    currency_id: Number;
    currency_desc: string;
    currency_value: Number;
}