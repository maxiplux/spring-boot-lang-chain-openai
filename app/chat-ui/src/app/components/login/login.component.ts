import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import Swal from 'sweetalert2';
import {AngularFireAuth, AngularFireAuthModule} from "@angular/fire/compat/auth";
import {AngularFireDatabaseModule} from "@angular/fire/compat/database";
import {AngularFireModule} from "@angular/fire/compat";
import {environment} from "../../../environments/environment";


import {Login} from "../../models/Login";





@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,FormsModule,CommonModule,

    AngularFireAuthModule,
    AngularFireDatabaseModule,
  ],
  templateUrl: './login.component.html',

})
export class LoginComponent  implements OnInit {
  titulo: string = 'Por favor Sign In!';
  login: Login;


  constructor(private authService: AuthService, private router: Router) {
    this.login= { email: '', password: '', rememberMe: false };
  }

  ngOnInit() {
    if (this.authService.isAuthenticated())
    {
      Swal.fire('Login', `Hello ${this.authService.currentUser().displayName} !`, 'info');
      this.router.navigate(['/dashboard/produtos']);
    }
  }


  doLogin(): void {

    if (this.login.email == null || this.login.password == null)
    {
      Swal.fire('Error Login', 'Username or password empty!', 'error');
      return;
    }
    this.authService.login(this.login.email, this.login.password).then(response => {
      this.router.navigate(['/dashboard/chat']);

      Swal.fire({
        title: "Login!",
        text: `Hello ${this.authService.currentUser().email} !`,
        icon: "success"
      });

    }).catch(err => {
      if (err.status == 400)
      {
        Swal.fire('Error Login', 'Username or Password wrong!', 'error');
    }});


  }



}
