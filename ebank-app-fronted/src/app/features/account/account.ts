import {Component, inject, signal} from '@angular/core';
import {AccountService} from '../../services/account-service';
import {CurrencyPipe, DatePipe} from '@angular/common';
import {AccountModel} from '../../models/account-model';
import {Customer as CustomerModel} from '../../models/customer';

@Component({
  selector: 'app-account',
  imports: [
    DatePipe,
    CurrencyPipe
  ],
  templateUrl: './account.html',
  styleUrl: './account.css',
})
export class Account {
        protected accountService : AccountService = inject(AccountService);
        selectedAccount = signal<AccountModel | null>(null);

  protected viewAccount(account: any) {
        this.selectedAccount.set(account);
  }
}
