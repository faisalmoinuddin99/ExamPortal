import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(
    private smack: MatSnackBar,
    private loginService: LoginService,
    private router: Router
  ) {}

  loginData = {
    username: '',
    password: '',
  };

  ngOnInit(): void {}

  formSubmit() {
    console.log('login button submitted');

    if (
      this.loginData.username.trim() == '' ||
      this.loginData.username == null
    ) {
      this.smack.open('Username is required !!', '', {
        duration: 3000,
      });
      return;
    }
    if (
      this.loginData.password.trim() == '' ||
      this.loginData.password == null
    ) {
      this.smack.open('Password is required !!', '', {
        duration: 3000,
      });
      return;
    }

    // request server to generate token
    this.loginService.generateToken(this.loginData).subscribe(
      (data: any) => {
        console.log('success');
        console.log(data);
        console.log(data.token);

        // login...
        this.loginService.loginUser(data.token);

        this.loginService.getCurrentUser().subscribe(
          (userData: any) => {
            console.log(userData);
            this.loginService.setUser(userData);

            // redirect ... ADMIN admin-dashboard
            // redirect ... USER: normal user dashboad
            if (this.loginService.getUserRole() == 'ADMIN') {
              // admin dashboard
              // window.location.href='/admin'
              this.router.navigate(['admin']);
              this.loginService.loginStatusSubject.next(true);
            } else if (this.loginService.getUserRole() == 'USER') {
              // normal user dashboard
              // window.location.href='/user-dashboard'
              this.router.navigate(['user-dashboard']);
              this.loginService.loginStatusSubject.next(true);
            } else {
              this.loginService.logout();
              // location.reload()
            }
          },
          (error) => {
            console.log(error);
          }
        );
      },
      (error: any) => {
        console.log('Error !');
        console.log(error);

        this.smack.open('Invalid Details !!', '', {
          duration: 3000,
        });
      }
    );
  }
}
