import { Routes } from '@angular/router';


export const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard',  loadComponent: () => import('./features/dashboard/dashboard').then(m => m.Dashboard) },
  { path: 'customers',  loadComponent: () => import('./features/customer/customer').then(m => m.Customer  ) },
  { path: 'accounts',   loadComponent: () => import('./features/account/account').then(m => m.Account) },
  { path: 'chat',       loadComponent: () => import('./features/chat/chat').then(m => m.Chat) }, // si existant
  { path: 'settings',   loadComponent: () => import('./features/settings/settings').then(m => m.Settings) }, // si existant
  { path: '**', redirectTo: '/dashboard' }
];
