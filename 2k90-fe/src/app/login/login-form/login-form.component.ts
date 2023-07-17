import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    const url = "http://localhost:8080/testget";
    const header: HttpHeaders = new HttpHeaders().set("Authorization", "Basic " + btoa("wiktor:vizi"));
    //this.http.get<any>(url, {headers: header}).subscribe(d => console.log(d));

    const url_login = "http://localhost:8080/login";
    const body = {
      username: "wiktor",
      password: "vizi"
    }

    this.http.post<any>(url_login, body, {headers: header}).subscribe(d => console.log(d));
    this.http.get(url_login, {responseType: 'text'}).subscribe(d => console.log(d));
  }
}
