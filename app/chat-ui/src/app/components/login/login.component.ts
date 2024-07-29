import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {User} from "../../models/User";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,FormsModule,CommonModule],
  templateUrl: './login.component.html',

})
export class LoginComponent  implements OnInit {
  titulo: string = 'Por favor Sign In!';
  user: User;

  constructor(private authService: AuthService, private router: Router) {
    this.user = new User();
  }

  ngOnInit() {
    if (this.authService.isAuthenticated())
    {
      Swal.fire('Login', `Hello ${this.authService.user.username} !`, 'info');
      this.router.navigate(['/dashboard/produtos']);
    }
  }

  login(): void {

    if (this.user.username == null || this.user.password == null)
    {
      Swal.fire('Error Login', 'Username or password empty!', 'error');
      return;
    }


  }



}
