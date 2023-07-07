import { Component } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  public model = {
    login: null,
    password: null
  }

  onLoginChange(value: any) {
    this.model.login = value;
  }
}
