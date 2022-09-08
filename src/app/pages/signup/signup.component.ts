import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserServiceService } from 'src/app/services/user-service.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserServiceService, private _snackBar: MatSnackBar) { }

  durationInSecond = 3 ;

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
    if(this.user.username == '' || this.user.username == null){
    //  alert("user name is required")
    this._snackBar.open("Username is required !!", "ok",{
      duration: this.durationInSecond * 1000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    })
      return
      
    }
    // addUser: userservice
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        // success
        console.log(data);
        Swal.fire(
          'Done !',
          `You are registered now 😊 with id ${data.id}`,
          'success'
        )
        
      },
      (error: any) => {
        // error
        console.log(error);
        // alert("something went wrong")
        this._snackBar.open('something went wrong !!', '',{
          duration: 3000
        })
        
      }
    )
  }
}
