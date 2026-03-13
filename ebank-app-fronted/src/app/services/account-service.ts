import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {httpResource} from '@angular/common/http';
import {AccountModel} from '../models/account-model';

@Injectable({
  providedIn: 'root',
})
export class AccountService {

  private baseUrl: string = environment.apiGatewayUrl; // Assurez-vous que cette URL correspond à votre API Spring Boot
  readonly  accountResource = httpResource<AccountModel[]>(() => `${this.baseUrl}/EBANK-SERVICE/api/accounts`); // Remplacez 'any' par le type de données approprié pour vos comptes



}
