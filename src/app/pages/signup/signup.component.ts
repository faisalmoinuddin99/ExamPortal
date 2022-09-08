import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserServiceService) { }

  public user = {
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:''
  }

  ngOnInit(): void {
  }


  formSubmit(){
    console.log(this.user);
    alert("submit")
    if(this.user.firstName == ''){
      console.log("please fill firstname");
      return
      
    }
    // addUser: userservice
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        // success
        console.log(data);
        alert("success") ;
        
      },
      (error: any) => {
        // error
        console.log(error);
        alert("something went wrong")
        
      }
    )
  }
}
