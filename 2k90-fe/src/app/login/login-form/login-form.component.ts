import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  private submitUrl: string;

  constructor(
    private http: HttpClient
  ) {
    this.submitUrl = "http://localhost:8080/api/auth/login";
  }

  public model = {
    username: null,
    password: null
  }

  onUsernameChange(value: any) {
    this.model.username = value;
  }

  onLoginClicked() {
    this.http.post(this.submitUrl, this.model, {responseType: 'text'}).subscribe(response => {
      if (response == "Success") {
        console.log("Zalogowano")
      } else {
        console.log("Nie udalo sie zalogowac");
      }
    })
  }
}
