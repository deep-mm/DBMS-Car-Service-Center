export class Login {
    username: string;
    password: string;
    role: string;

    constructor(json?: any) {
        if (json) {
            this.username = json.username;
            this.password = json.password;
            this.role = json.role;
        }
        else{
            this.username = "";
            this.password = "";
            this.role = "";
        }
    }
}