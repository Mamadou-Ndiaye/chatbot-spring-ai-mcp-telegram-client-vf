import {Component, HostListener, inject, OnInit} from '@angular/core';
import {Sidebar as SidebarService} from '../../services/sidebar';
import {NgClass} from '@angular/common';
import {RouterLink, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'app-sidebar',
  imports: [
    NgClass,
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './sidebar.html',
  styleUrl: './sidebar.css',
})
export class Sidebar {

  public sidebar : SidebarService = inject(SidebarService);

  isMobileView = this.sidebar.isMobile;
  isOpen = this.sidebar.isOpen;

  toggleSidebar() {
    this.sidebar.toggle();
  }

  closeSidebar() {
    if (this.isMobileView()) {
      this.sidebar.close();
    }
  }
}
