import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent {
  public model = {
    login: null,
    password: null,
    passwordConfirmation: null
  }

  public blur = {
    login: false,
    password: false,
    passwordConfirmation: false
  }

  public error: boolean = false;

  onLoginChange(value: any) {
    this.model.login = value;
  }

  onSubmit() {
    console.log(this.model.login);
  }
  
}
