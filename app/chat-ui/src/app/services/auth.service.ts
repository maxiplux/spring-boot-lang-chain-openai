import { Injectable } from '@angular/core';

import {AngularFireAuth} from "@angular/fire/compat/auth";
import { GoogleAuthProvider } from 'firebase/auth';

import {SimpleUser} from "../models/SimpleUser";  // Use AngularFire's User type











@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: SimpleUser  ;

  constructor(public afAuth: AngularFireAuth) {
    this.user = {displayName: '' , email: ''};
    this.afAuth.authState.subscribe((user) => {

      this.user = {displayName: user?.displayName || 'MISSING DATA', email: user?.email || 'MISSING DATA'};

      user?.getIdToken().then(token => {

        this.user.token = token;
        return token;
      });


    });
  }

  login(email: string, password: string) {
    return this.afAuth.signInWithEmailAndPassword(email, password);
  }

  loginWithGoogle() {
    return this.afAuth.signInWithPopup(new GoogleAuthProvider());
  }



  logout() {

    return this.afAuth.signOut();
  }

  isAuthenticated() {
    return this.user?.email !== '';
  }

  currentUser() :SimpleUser {
    return this.user;
  }

  setToken() {
    this.afAuth.currentUser.then(user => {
      user?.getIdToken().then(token => {

        this.user.token = token;
        return token;
      });
    });
  }
}
