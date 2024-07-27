import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private services:string=`https://api.github.com/users/`;

  constructor() { }

  getAnswer(question:string):Observable<string>{
    return of(`I am a bot, I do not understand your question "${question}"`);
  }


}
