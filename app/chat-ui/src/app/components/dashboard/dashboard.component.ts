import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {ChatComponent} from "../chat/chat.component";
import {HeaderComponent} from "../../menus/header/header.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    RouterOutlet,
    ChatComponent,
    HeaderComponent
  ],
  templateUrl: './dashboard.component.html',

})
export class DashboardComponent {
  title = 'dashboard';

}
