import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {BehaviorSubject} from 'rxjs';
import {map, tap} from 'rxjs/operators';
import {loginUser,FXrequest} from './fx-model.model';

@Injectable({
    providedIn: 'root'
})
export class FxServiceService {

  public baseurl = 'http://localhost:8080/FxDeals/';
  public token = 'Bearer '+String(localStorage.getItem('token'));
  public headerOptions = new HttpHeaders({
    'Content-Type': 'application/json-patch+json',
  });
  public headerOptions2 = new HttpHeaders();

  constructor(private _http: HttpClient) { 
  }

  public Login(user : loginUser): Observable<any>{
    return this._http.post<any>(this.baseurl+"FXDealsAuthentication/authenticate",user, {headers: this.headerOptions, observe: 'response'});
  }

  public getOptions(user_id : Number): Observable<any>{
    let req = new FXrequest;
    req.user_id = user_id;
    this.headerOptions2.append('Content-Type', 'application/json-patch+json');
    this.headerOptions2.append('Access-Control-Allow-Origin', '*');
    this.headerOptions2.append('Access-Control-Allow-Credentials', 'true');
    this.headerOptions2.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
    this.headerOptions2.append('Access-Control-Allow-Headers', 'Origin, Content-Type, Accept, Authorization');
    this.headerOptions2.append('Authorization', 'Bearer '+String(localStorage.getItem('token')));
    return this._http.post<any>(this.baseurl+"api/main/getOptions",req, {headers: this.headerOptions2, observe: 'response'});
  }

  public getUserInfo(user_name: string): Observable<any>{
    let req = new FXrequest;
    console.log({req})
    console.log("this.token",this.token);
    req.username = user_name;
    this.headerOptions2.append('Content-Type', 'application/json-patch+json');
    this.headerOptions2.append('Access-Control-Allow-Origin', '/');
    this.headerOptions2.append('Access-Control-Allow-Credentials', 'true');
    this.headerOptions2.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
    this.headerOptions2.append('Access-Control-Allow-Headers', 'Origin, Content-Type, Accept, Authorization');
    this.headerOptions2.append('Authorization', 'Bearer '+this.token);
    this.headerOptions2.set('Authorization', `Bearer ${this.token}`);
    return this._http.post<any>(this.baseurl+"api/main/getUserInfo",req, {headers: this.headerOptions2, observe: 'response'});
  }

  errorHandler(error: HttpErrorResponse) {
      return Observable.throw(error.message || 'server error');
  }
}
