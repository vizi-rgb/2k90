import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisterUserDTO } from 'src/app/interfaces/register-user-interface';


@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent {

  private submitURL: string;
  
  public userAlreadyExistsError: boolean = false;
  public dataInvalidError: boolean = false;

  public model = {
    username: null,
    email: null,
    password: null,
    passwordConfirmation: null
  }

  constructor(
    private http: HttpClient,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {
    this.submitURL = "http://localhost:8080/api/auth/register";
  }


  onUsernameChange(value: any) {
    this.model.username = value;
  }

  onRegisterSubmit() {
    const userDTO: RegisterUserDTO = {
      username: this.model.username,
      email: this.model.email,
      password: this.model.password,
      passwordConfirmation: this.model.passwordConfirmation
    };

    this.userAlreadyExistsError = false;
    this.dataInvalidError = false;

    this.http.post(this.submitURL, userDTO, {responseType: 'text'}).subscribe(data => {
      if (data == "Success") {
        this.router.navigate(
          ['success'], {
          relativeTo: this.activeRoute,
          queryParams: {username: this.model.username}
        });
      } else if (data == "User already exists"){
        this.userAlreadyExistsError = true;
      } else if (data == "Data invalid") {
        this.dataInvalidError = true;
      }

      console.log(data);
    });
  }
  
}
