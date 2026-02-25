import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Sidebar {
  // État principal : sidebar ouverte ou fermée
  isOpen = signal<boolean>(true);          // ouvert par défaut sur desktop

  // Détection mobile/desktop
  isMobile = signal<boolean>(window.innerWidth < 768);

  constructor() {
    // Écoute du redimensionnement de la fenêtre
    window.addEventListener('resize', () => {
      this.isMobile.set(window.innerWidth < 768);

      // Sur desktop → on rouvre automatiquement
      if (!this.isMobile()) {
        this.isOpen.set(true);
      }
    });
  }

  // Méthodes publiques
  toggle() {
    this.isOpen.update(value => !value);
  }

  open() {
    this.isOpen.set(true);
  }

  close() {
    this.isOpen.set(false);
  }

}
