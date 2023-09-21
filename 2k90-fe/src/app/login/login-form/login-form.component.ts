import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent {

  public model = {
    username: null,
    password: null
  }

  public show: boolean = false;

  constructor(
    private http: HttpClient
  ) { }

  onUsernameChange(value: any) {
    this.model.username = value;
  }

  onLoginClicked() {
    const url_login = "http://localhost:8080/api/auth/login";

    this.http.post(url_login, this.model, {responseType: 'text'}).subscribe({
      next: (v) => console.log(v),
      error: (e) => console.log('dupa'),
      complete: () => console.log('complete')
    });
  }
}
