import {inject, Injectable, signal} from '@angular/core';
import {HttpClient, httpResource} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Customer as Customers } from '../models/customer';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class Customer {
      private http = inject(HttpClient);
        private apiUrl = environment.apiGatewayUrl ; // Assurez-vous que cette URL correspond à votre API Spring Boot



      readonly customersResource = httpResource<Customers[]>(() =>
        `${this.apiUrl}/CUSTOMER-SERVICE/api/customers`
      );

      updateCustomer(customer: Customers): Observable<Customers> {
        return this.http.put<Customers>(`${this.apiUrl}/CUSTOMER-SERVICE/api/customers/${customer.id}`, customer);
      }
}
