import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiurl = 'http://localhost:8080/api/auth';
  private tokenkey = 'jwt_token';

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string) {
    return this.http
      .post<any>(`${this.apiurl}/login`, { username, password })
      .pipe(
        tap((response) => {
          localStorage.setItem(this.tokenkey, response.token);
        })
      );
  }

  logout() {
    localStorage.removeItem(this.tokenkey);
    this.router.navigate(['/login']);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenkey);
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }
}
