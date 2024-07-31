import {Component, OnInit} from '@angular/core';
import {ChatService} from "../../services/chat.service";
import {FormsModule} from "@angular/forms";
import {AnswerComponent} from "./answer/answer.component";
import {QuestionComponent} from "./question/question.component";

import { ChatModel } from '../../models/ChatModel';
import {SimpleAnswer} from "../../models/SimpleAnswer";


@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [
    FormsModule,
    AnswerComponent,
    QuestionComponent
  ],
  templateUrl: './chat.component.html',

})
export class ChatComponent  implements OnInit {

  message:string = ''
  messagesChatModel: ChatModel[] = [];

  constructor(private chatService : ChatService) {
  }

  ngOnInit() {

    this.messagesChatModel.push(
      { isQuestion: false, body: 'Hello, I am a bot, how can I help you?', id: 0 },
      { isQuestion: true, body: 'I need assistance with my project.', id: 1 }
    );

  }

  sendMessage(){
    this.messagesChatModel.push({ isQuestion: true, body: this.message, id: this.messagesChatModel.length  });
    this.chatService.getAnswer({message:this.message}).subscribe((simpleAnswer: SimpleAnswer) => {
      this.messagesChatModel.push({ isQuestion: false, body: simpleAnswer.answer , id: this.messagesChatModel.length });
      this.message = '';
    });

  }

}
