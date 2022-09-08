import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseURL from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

 // generate token
 public generateToken(loginData: any){
  return this.http.post(`${baseURL}/generate-token`,loginData)
 }

 //  login user: set token in local storage
 public loginUser(token: any){
  localStorage.setItem("token", token) ;
  return true ;
 }

 // isLogi: user is logged in or not
 public isLoggedIn(){
  let tokenStr = localStorage.getItem("token")
  console.log(tokenStr);
  if(tokenStr == undefined || tokenStr == '' || tokenStr== null){
    return false ;
  }else {
    return true ;
  }
  }

  // logout : remove token from local storage
  public logout(){
    localStorage.removeItem("token")
    localStorage.removeItem("user")
    return true ;
  }

  // get token
  public getToken(){
    return localStorage.getItem("token") ;
  }

  // set userDetail
  public setUser(user: any){
    localStorage.setItem("user", JSON.stringify(user))
  }

  // get userDetail
  public getUser(){
    let userStr = localStorage.getItem('user')
    if(userStr != null){
      return JSON.parse(userStr)
    }else {
      this.logout()
      return null
    }
  }

  // get user role
  public getUserRole(){
    let user = this.getUser()
    // return user.authorities --> return all autherorities object
    return user.authorities[0].authority
  }
}
