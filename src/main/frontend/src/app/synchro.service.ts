import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import { Http,Headers,URLSearchParams,Response } from '@angular/http';
import { webServiceEndpoint } from './constants'

@Injectable()
export class SynchroService {
    constructor(private http: Http) { }

comment(comment){     
       return this.http.post('http://localhost:8080/journal/comment',comment)
       .map(res => res.json());
}

paginate(page){     
       return this.http.post('http://localhost:8080/journal/paginate',page)
       .map(res => res.json());
}
 
    getAllArticles(){
        console.log("acess");
            return this.http.get('http://localhost:8080/journal/allArticles').map(res => res.json());    
    }


   
}