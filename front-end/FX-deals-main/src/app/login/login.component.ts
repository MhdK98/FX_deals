import { Component, OnInit ,Inject} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {FxServiceService} from '../fx-service.service';
import {loginUser} from '../fx-model.model';
import {HttpResponse} from '@angular/common/http';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatTable} from '@angular/material';
import { RouterModule, Routes, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
  public user: loginUser;
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private service: FxServiceService, private router: Router) {
    this.createForm();
   }

  ngOnInit(): void {
    this.createForm();
  }

  private createForm() {
    this.loginForm = this.fb.group({
        username: ['test_user', Validators.required],
        password: ['123', Validators.required],
    });
}

public getCredintials(){
  let x = new loginUser;
  x.username = this.loginForm.controls.username.value;
  x.password = this.loginForm.controls.password.value;
  //this.user.username = this.loginForm.controls.username.value;
  //this.user.password = this.loginForm.controls.password.value;
  this.service.Login(x).subscribe(
    (data: HttpResponse<any>) => {
      console.log({data});
      this.user = x;
      localStorage.setItem("token",data.body.token);
      localStorage.setItem("user_name",this.user.username);
      console.log("token",localStorage.getItem("token"));
      this.router.navigate(['../myDeals']);
    }
);
}

}
