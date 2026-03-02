import {Component, input, output} from '@angular/core';
import {Customer as CustomerModel} from '../../models/customer';

@Component({
  selector: 'app-customer-detail',
  imports: [],
  templateUrl: './customer-detail.html',
  styleUrl: './customer-detail.css',
})
export class CustomerDetail {
  // Input : le client à afficher
  customerModel = input<CustomerModel | null>(null);

  // Output : pour fermer la modale
  close = output<void>();
}
