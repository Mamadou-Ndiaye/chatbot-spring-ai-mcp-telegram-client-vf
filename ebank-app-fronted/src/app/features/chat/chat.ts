import {Component, inject, signal} from '@angular/core';
import {ChatService} from '../../services/chat-service';

@Component({
  selector: 'app-chat',
  imports: [],
  templateUrl: './chat.html',
  styleUrl: './chat.css',
})
export class Chat {

  chatService : ChatService= inject(ChatService);
  prompt = signal('');
  loading = signal(false);

  send() {
    const query = this.prompt().trim();
    if (!query) {
      return;
    }
    this.loading.set(true);
    this.prompt.set(''); // On vide le champ
    this.chatService.ask(query).subscribe({
      next: (response) => {
        this.chatService.messages.update(m => [...m, {role: 'bot', text: response}]);
        this.prompt.set('');
        this.loading.set(false);
      },
      error: (err) => {
        console.error('Erreur API:', err);
        this.loading.set(false);
      }
    });
  }


}
