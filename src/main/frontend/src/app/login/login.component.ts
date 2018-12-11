import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { SynchroService } from '../synchro.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RestResponse } from '../models/restresponse';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { webServiceEndpoint } from '../constants'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg:string;
  err:boolean=false;
  model: any = {};
  constructor(private spinnerService: Ng4LoadingSpinnerService,private http: HttpClient,private myRoute: Router) { }

  ngOnInit() { }

   login() {

    this.spinnerService.show();
    return this.http.post<RestResponse>('http://localhost:8080/journal/auth', 
    { username: this.model.username, password: this.model.password }).subscribe( 
      (res : RestResponse) => {
        this.spinnerService.hide();
      localStorage.setItem("currentUser",JSON.stringify(res.user));
      this.myRoute.navigate(["home"]);},
      (error)=>{
      this.spinnerService.hide();
       this.msg=error.error.message;
       this.err=true;
    });
   
  } 

}
