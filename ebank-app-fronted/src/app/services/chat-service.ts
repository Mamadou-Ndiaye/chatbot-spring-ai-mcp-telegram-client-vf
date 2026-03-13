import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';




export interface ChatResponse {
  response: string;
}

@Injectable({
  providedIn: 'root',
})
export class ChatService {

  private http = inject(HttpClient);
  private apiUrl = environment.apiGatewayUrl;
  messages = signal<{role: 'user' | 'bot', text: string}[]>([]);

  ask(question: string) {
    this.messages.update(m=> [...m, {role: 'user', text: question}]);
    return this.http.get(`${this.apiUrl}/EBANK-CHAT/api/chat`, { params: {query :  question } ,  responseType: 'text' } );
  }



}
