import { OnInit, Component } from "@angular/core";
import { User } from '../models/user';
import { SynchroService } from "../synchro.service";
import { Http, Headers, URLSearchParams, Response, RequestOptions } from '@angular/http';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Article } from "../models/article";
import { HttpParams, HttpHeaders } from "@angular/common/http";
import { PageRequest } from "../models/pagerequest";
import { Router } from "@angular/router";


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

   formData:FormData = new FormData();
   display:boolean=false;
   article:Article = new Article();
   userArgus:User;

  constructor(private spinnerService: Ng4LoadingSpinnerService,private myRoute: Router,private http: Http,private synchroService:SynchroService) { }

  ngOnInit() {
    this.userArgus=JSON.parse(localStorage.getItem("currentUser"));
  }

  accueilPage (){
 this.myRoute.navigate(["home"]);
}

articlesPage(){
 this.myRoute.navigate(["article"]);
}

ajouter(){

    let headers = new Headers();
       this.article.user=this.userArgus;
       headers.append('Accept', 'application/json');
        let options = new RequestOptions({ headers: headers });
        this.formData.append('title',this.article.title);
        this.formData.append('text',this.article.text);
        this.formData.append('user',JSON.stringify(this.userArgus.idUser));

      console.log("data "+this.formData);
       console.log("data 2 "+JSON.stringify(this.formData));
        this.http.post('http://localhost:8080/journal/addArticle', this.formData, options)
           
            .subscribe(
                (data) =>{ console.log('success'+data);
                this.display=true;
                this.article.title="";
                this.article.text="";
                this.formData = new FormData();
               this.article.picture="";
              },
                (error) =>{ console.log(error);
              }
            );

}
fileChange(event) {
  console.log("filee up");
    let fileList: FileList = event.target.files;
    if(fileList.length > 0) {
      console.log("good length ");
        let file: File = fileList[0];
        
        this.formData.append('file', file, file.name);
      
    }
}

  logout(){
    localStorage.removeItem("currentUser");
    this.myRoute.navigate(["login"]);
  }

    closeDialog(){
    this.display=false;
  }
  
}


