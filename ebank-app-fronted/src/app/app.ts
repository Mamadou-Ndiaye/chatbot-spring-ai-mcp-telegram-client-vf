import {Component, computed, inject, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {CommonModule} from '@angular/common';
import {Sidebar  as SidebarService} from './services/sidebar';
import {Sidebar} from './layout/sidebar/sidebar';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CommonModule,Sidebar],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ebank-app-fronted');
  private sidebarService = inject(SidebarService);

  // Computed signals pour le template (plus performants et réactifs)
  isMobileView = this.sidebarService.isMobile;
  isSidebarOpen = this.sidebarService.isOpen;

  // Pour calculer la marge gauche du contenu principal
  mainMarginLeft = computed(() => {
    if (this.isMobileView()) return '0';
    return this.isSidebarOpen() ? '280px' : '0';
  });

  // Méthode toggle appelée depuis le bouton navbar
  toggleSidebar() {
    this.sidebarService.toggle();
  }
}
