import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

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
    private http: HttpClient,
    private authenticationService: AuthenticationService
  ) { }

  onUsernameChange(value: any) {
    this.model.username = value;
  }

  onLoginClicked() {
      this.authenticationService.doLogin({
        username: this.model.username!,
        password: this.model.password!
      });
  }
}
