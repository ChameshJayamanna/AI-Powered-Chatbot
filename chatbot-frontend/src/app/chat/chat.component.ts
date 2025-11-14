import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChatService } from '../chat.service';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports:[FormsModule, CommonModule],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css'
})
export class ChatComponent {
message = '';
  messages: { text: string, type: 'user' | 'bot' }[] = [];

  constructor(private chatService: ChatService) {}

  send() {
    if (!this.message.trim()) return;

    // Add user message
    this.messages.push({ text: this.message, type: 'user' });

  this.chatService.sendMessage(this.message).subscribe({
  next: res => {
    // Use res.reply instead of res
    this.messages.push({ text: res.reply, type: 'bot' });
  },
  error: err => {
    console.error('Error from backend:', err);
    this.messages.push({ text: '⚠️ Cannot reach backend', type: 'bot' });
  }
  });
}}
