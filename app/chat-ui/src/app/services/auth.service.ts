import { Injectable } from '@angular/core';
import {User} from "../models/User";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User;

  constructor() {
    this.user = new User();
  }

  isAuthenticated() {
    return false;
  }
}
