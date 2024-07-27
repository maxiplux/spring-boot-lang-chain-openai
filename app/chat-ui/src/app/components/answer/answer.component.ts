import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-answer',
  standalone: true,
  imports: [],
  templateUrl: './answer.component.html',

})
export class AnswerComponent {
  @Input() answer: string = '';

}
