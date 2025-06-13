import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  standalone: true,
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  imports: [CommonModule],
})
export class DashboardComponent {
  message = '';

  constructor(private http: HttpClient, private auth: AuthService, private router: Router) {
    this.http.get<{ message: string }>('http://localhost:8080/dashboard/info', {
      headers: { Authorization: `Bearer ${this.auth.getToken()}` }
    }).subscribe({
      next: res => this.message = res.message,
      error: () => this.message = 'Access Denied'
    });
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}
