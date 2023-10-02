import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
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
    private authenticationService: AuthenticationService,
    private router: Router

  ) { }

  onUsernameChange(value: any) {
    this.model.username = value;
  }

  onLoginClicked() {
      this.authenticationService.doLogin({
        username: this.model.username!,
        password: this.model.password!
      });

      this.router.navigate(['home']);
  }
}
