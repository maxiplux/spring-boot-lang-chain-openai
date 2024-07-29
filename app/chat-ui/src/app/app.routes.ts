import { Routes } from '@angular/router';
import {ErrorsComponent} from "./components/errors/errors.component";
import {LoginComponent} from "./components/login/login.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {ChatComponent} from "./components/chat/chat.component";
//canActivate: [AuthGuard]
export const routes: Routes = [

  { path: '', redirectTo: '/dashboard/chat', pathMatch: 'full' },

  {
    path: 'dashboard',  component: DashboardComponent,     children: [
      { path: 'chat', component: ChatComponent },
    ]
  },

  { path: 'login',  component: LoginComponent},
  {path: '404',  component: ErrorsComponent},
  {path: '**', redirectTo: '/404'}

];
