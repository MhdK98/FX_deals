import { Component, OnInit ,Inject} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {FxServiceService} from '../fx-service.service';
import {loginUser,Currency,UserInfo} from '../fx-model.model';
import {HttpResponse} from '@angular/common/http';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatTable} from '@angular/material';
import { RouterModule, Routes, Router } from '@angular/router';

@Component({
  selector: 'app-my-deals',
  templateUrl: './my-deals.component.html',
  styleUrls: ['./my-deals.component.css']
})
export class MyDealsComponent implements OnInit {

  dealCalculator: FormGroup;
  currencies: Currency[];
  user: UserInfo;

  constructor(private fb: FormBuilder, private service: FxServiceService, private router: Router) {
    this.createForm();
    this.getOptions();
   }

  ngOnInit(): void {
  }

  private createForm() {
    this.dealCalculator = this.fb.group({
        fromCurr: [0, Validators.required],
        toCurr: [0, Validators.required],
        amount: [0, Validators.required],
    });
  }

  public getOptions(){
    let username:string = String(localStorage.getItem("user_name"));
    this.service.getUserInfo(username).subscribe(
      (data: HttpResponse<any>) => {
        console.log({data});
        this.user = data.body.userInfo;
        this.service.getOptions(this.user.user_id).subscribe(
          (data2: HttpResponse<any>) => {
            console.log({data2});
            this.currencies = data2.body.currencies;
            
          }
      );
      }
  );
  }

}
