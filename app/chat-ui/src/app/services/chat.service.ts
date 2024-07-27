import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import { HttpClient } from '@angular/common/http';

import {SimpleQuestion} from "../models/SimpleQuestion";

import {environment} from "../../environments/environment";
import {SimpleAnswer} from "../models/SimpleAnswer";

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private chatUrl:string=`${environment.serverUrl}${environment.chatEndpoint}`;


  constructor(private http: HttpClient) { }

  getAnswer(question:SimpleQuestion):Observable<SimpleAnswer>{
    console.log('Sending question to server: ', this.chatUrl, environment.isProduction);
    return this.http.post<SimpleAnswer>(this.chatUrl, question);
  }


}
