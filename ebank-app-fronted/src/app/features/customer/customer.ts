import {Component, inject, OnInit} from '@angular/core';
import { Customer as CustomerService } from '../../services/customer';
import { CommonModule } from '@angular/common';

import { Customer as CustomerModel } from '../../models/customer';

@Component({
  selector: 'app-customer',
  imports: [CommonModule],
  templateUrl: './customer.html',
  styleUrl: './customer.css',
  standalone: true,
})
export class Customer implements OnInit {


  customerService : CustomerService = inject(CustomerService) ;

  customers: CustomerModel[] = [];
  loading : boolean = true;
  error: string | null = null;

  ngOnInit() {
    this.loadCustomers();
  }

  loadCustomers() {
    this.loading = true;
    this.error = null;
    this.customers = [];

      this.customerService.getCustomers().subscribe({
         next: (data) => {
           console.log('Réponse reçue :', data);           // ← LOG IMPORTANT
           console.log('Type de data :', Array.isArray(data) ? 'tableau' : typeof data);
           this.customers = Array.isArray(data) ? data : [];
           this.loading = false;
           console.log('customers mis à jour :', this.customers.length, 'éléments');

         },
         error: (err) => {
           this.error = 'Error loading customers: ' + (err.message || err.statusText || 'Veriez le gateway');
           this.loading = false;
           console.log(err);
         },
        complete: () => {
           //this.loading = false;
          console.log('Requête terminée');
          }
      });
  }
}
