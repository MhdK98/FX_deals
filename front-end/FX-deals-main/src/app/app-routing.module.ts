import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MyDealsComponent} from './my-deals/my-deals.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  { path: 'myDeals', component: MyDealsComponent },
  { path: 'login', component: LoginComponent },
  { path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
