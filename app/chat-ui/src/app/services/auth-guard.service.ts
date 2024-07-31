import { Injectable } from '@angular/core';
import {CanActivate, Router} from "@angular/router";
import {AngularFireAuth} from "@angular/fire/compat/auth";
import {map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomAuthGuard implements CanActivate {

  constructor(private afAuth: AngularFireAuth, private router: Router) {}
  canActivate(): Observable<boolean> {
    return this.afAuth.authState.pipe(
      map((user) => {
        if (user) {
          return true;
        }

        this.router.navigate(['/login']);
        return false;

      })
    );
  }


}
