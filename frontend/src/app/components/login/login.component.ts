import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  public loginForm! : FormGroup;
  constructor(private fb : FormBuilder,
              private autService : AuthService,
              private router : Router) {
  }
  ngOnInit() {
    this.loginForm= this.fb.group({
      username : this.fb.control('admin'),
      password : this.fb.control('1234')
    });
  }

  login() {
    let username = this.loginForm.value.username;
    let password = this.loginForm.value.password;
    let auth = this.autService.login(username, password);
    if(auth==true){
      this.router.navigateByUrl("/admin")
    }
  }
}
