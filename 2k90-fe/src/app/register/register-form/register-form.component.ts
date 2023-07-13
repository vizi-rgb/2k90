import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegisterUser } from 'src/app/interfaces/register-user-interface';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent {

  private submitURL: string;

  constructor(
    private http: HttpClient
  ) {
    this.submitURL = "http://localhost:8080/api/auth/register";
  }

  public model = {
    username: null,
    email: null,
    password: null,
    passwordConfirmation: null
  }

  onUsernameChange(value: any) {
    this.model.username = value;
  }

  onRegisterSubmit() {
    const userDTO: RegisterUser = {
      username: this.model.username,
      email: this.model.email,
      password: this.model.password
    };

    this.http.post<RegisterUser>(this.submitURL, userDTO).subscribe(d => console.log(d));
  }
  
}
