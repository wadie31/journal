import { Component, OnInit, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { Comment } from '../models/comment';
import { SynchroService } from '../synchro.service';
import { Http, Headers, URLSearchParams, Response, RequestOptions } from '@angular/http';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Article } from "../models/article";
import { HttpParams, HttpHeaders } from "@angular/common/http";
import { PageRequest } from "../models/pagerequest";


@Component({
  selector: 'app-home', 
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser:string ;
  userArgus:User;
  
  username:string="";
  restResponse:string;
   display: boolean = false;
   disp: boolean = false;
   displayTable: boolean = false;
   visible: boolean = false;
  message:string="";
  mess:string="";
   nameList: Array<any>;
   articles: Array<Article> = new Array<Article>();
   commentaire:String="";
  formData:FormData = new FormData();
  comment:Comment = new Comment();
  comments :  Array<Comment>;
  page:number=0;
  pagereq:PageRequest = new PageRequest();
  

  constructor(private spinnerService: Ng4LoadingSpinnerService,private myRoute: Router,private http: Http,private synchroService:SynchroService) { }
accueilPage (){
 this.myRoute.navigate(["home"]);
}

articlesPage(){
 this.myRoute.navigate(["article"]);
}

onScrollDown () {
        console.log('scrolled down!!');
         this.page++;
       this.pagereq.page=this.page;
console.log("page req : "+JSON.stringify(this.pagereq));
         this.synchroService.paginate(this.pagereq).subscribe((res) => {
     console.log("logo"+JSON.stringify(res))
     if(res.length != 0){
       console.log("concat"+res.length);
        for (let entry of res) {
          console.log("loop ");
              this.articles.push(entry); // push the value into db
          }
            console.log("my articles "+JSON.stringify(this.articles));
    ;}
    else{
      console.log("zeroo");
      
    }
  },
  (error)=>{
console.log("error");
  });
    }

    on () {
        console.log('scrolled down!!');
         this.page=1;
       this.pagereq.page=this.page;
console.log("page req : "+JSON.stringify(this.pagereq));
         this.synchroService.paginate(this.pagereq).subscribe((res) => {
     console.log("logo"+JSON.stringify(res))
     if(res.length != 0){
       console.log("concat"+res.length);
        this.articles=res;
        
    }
    else{
      console.log("nada");
      
    }
  },
  (error)=>{
console.log("error");
  });
    }
 
refresh(){
  this.synchroService.getAllArticles().subscribe((res) => {
     console.log("logo"+JSON.stringify(res))
    this.articles=res;
  }
     ,
     (error)=>{
       console.log("error");
     });
}
  ngOnInit() {
  // this.refresh();
  this.onScrollDown();
    this.userArgus=JSON.parse(localStorage.getItem("currentUser"));
  }

  commenter(articleId){
    let art:Article = new Article();
    console.log("user idddd"+articleId);
 console.log("user"+JSON.stringify(this.userArgus));
 this.comment.user=this.userArgus;
 art.id=articleId;
 this.comment.article=art;
  console.log("super log"+JSON.stringify(this.comment.article));
 
    this.synchroService.comment(this.comment).subscribe((res) => {
     console.log("log :"+JSON.stringify(res));
     this.comment.commentaire="";
      this.on();
  }
     ,
     (error)=>{
       console.log("error");
     });
  }

    logout(){
    localStorage.removeItem("currentUser");
    this.myRoute.navigate(["login"]);
  }


  closeDialog(){
    this.display=false;
    this.visible=false;
    this.disp=false;
  }
}
