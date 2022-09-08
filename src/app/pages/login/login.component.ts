import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private smack: MatSnackBar, private loginService: LoginService) { }

  loginData = {
    username: '',
    password: ''
  }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log("login button submitted");

    if(this.loginData.username.trim() == '' || this.loginData.username == null){
        this.smack.open("Username is required !!" ,'',{
          duration:3000
        })
        return
    }
    if(this.loginData.password.trim() == '' || this.loginData.password == null){
      this.smack.open("Password is required !!" ,'',{
        duration:3000
      })
      return
  }

  // request server to generate token
  this.loginService.generateToken(this.loginData).subscribe(
    (data: any) =>{
      console.log("success");
      console.log(data);
    },
    (error: any) => {
      console.log("Error !");
      console.log(error);
      
      
    }
    ) ;
    
  }
}
