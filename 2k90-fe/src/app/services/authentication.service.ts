import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUserDTO } from '../interfaces/login-user-interface';
import { User } from '../interfaces/user';
import { BehaviorSubject, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  readonly loginEndpoint: string;

  private authenticated: boolean;
  private basicAuthorization: HttpHeaders | undefined;
  private userSubject: BehaviorSubject<User | null>;
  public user: Observable<User | null>;

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
    this.authenticated = false;
    this.loginEndpoint = "http://localhost:8080/api/auth/login";

    this.userSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('user')!));
    this.user = this.userSubject.asObservable();
    if (this.userSubject.value) {
      this.authenticated = true;
    }
  }

  get isAuthenticated(): boolean {
    return this.authenticated;
  }

  public get userValue() {
    return this.userSubject.value;
  }

  doLogin(userDTO: LoginUserDTO): void {
    this.http.post(this.loginEndpoint, userDTO, {responseType: 'text'})
      .subscribe({

        next: (v) => {
          this.authenticated = true;
          const base64UsernamePassword: string = btoa(userDTO.username + ':' + userDTO.password);
          this.basicAuthorization = new HttpHeaders({'Authorization:': 'Basic' + base64UsernamePassword});
          localStorage.setItem('user', v);
          const vJson = JSON.parse(v);
          this.userSubject.next({
            id: vJson.id,
            username: vJson.username,
            email: vJson.email
          });
        },

        error: (e) => {
            throw new Error("Wrong credentials");
        },

        complete: () => console.log('complete')
      });
  }

  doLogout() {
    localStorage.removeItem('user');
    this.userSubject.next(null);
    this.authenticated = false;
    this.basicAuthorization = undefined;
    this.router.navigate(['login']);
  }
}
