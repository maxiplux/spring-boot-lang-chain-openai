import { Routes } from '@angular/router';
import {ErrorsComponent} from "./components/errors/errors.component";
import {LoginComponent} from "./components/login/login.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {ChatComponent} from "./components/chat/chat.component";
import {CustomAuthGuard} from "./services/auth-guard.service";
import {DocumentsComponent} from "./components/documents/documents.component";
import {UsersComponent} from "./components/users/users.component";

//canActivate: [AuthGuard]
export const routes: Routes = [

  { path: '', redirectTo: '/dashboard/chat', pathMatch: 'full' },

  {
    path: 'dashboard',  component: DashboardComponent, canActivate: [CustomAuthGuard],    children: [

      { path: 'chat', component: ChatComponent },
      { path: 'documents', component: DocumentsComponent },
      { path: 'users', component: UsersComponent },
    ]
  },

  { path: 'login',  component: LoginComponent},
  {path: '404',  component: ErrorsComponent},
  {path: '**', redirectTo: '/404'}

];
