import { Component } from '@angular/core';
import { ChatComponent } from './chat/chat.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ChatComponent],  // <-- import your standalone ChatComponent
  template: `
    <h1 style="text-align:center;">CX BOT</h1>
    <app-chat></app-chat>
  `
})
export class AppComponent {}
