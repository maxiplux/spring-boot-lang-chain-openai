import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { OnInit } from '@angular/core';
import { initFlowbite } from 'flowbite';
import {ContentComponent} from "./content/content.component";
import {ChatComponent} from "./components/chat/chat.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ContentComponent, ChatComponent],
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  title = 'chat-ui';




  ngOnInit() {
    initFlowbite();
    const userMenuButton = document.getElementById('user-menu-button');
    const userMenu = document.getElementById('user-menu');

    userMenuButton?.addEventListener('click', () => {
      userMenu?.classList.toggle('hidden');
    });
  }
}
