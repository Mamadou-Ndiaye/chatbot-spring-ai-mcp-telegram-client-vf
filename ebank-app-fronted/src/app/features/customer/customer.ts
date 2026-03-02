import {Component, inject, OnInit, signal} from '@angular/core';
import { Customer as CustomerService } from '../../services/customer';
import { Customer as CustomerModel } from '../../models/customer';
import { CommonModule } from '@angular/common';
import {CustomerDetail} from '../customer-detail/customer-detail';

@Component({
  selector: 'app-customer',
  imports: [CommonModule, CustomerDetail],
  templateUrl: './customer.html',
  styleUrl: './customer.css',
  standalone: true,
})
export class Customer {


  customerService : CustomerService = inject(CustomerService) ;
  // Le client actuellement sélectionné pour le détail
  selectedCustomer = signal<CustomerModel | null>(null);


  // Méthode appelée quand on clique sur "Voir"
  viewCustomer(customer: CustomerModel) {
    this.selectedCustomer.set(customer);
  }

  // Fermer la modale
  closeDetail() {
    this.selectedCustomer.set(null);
  }
}
