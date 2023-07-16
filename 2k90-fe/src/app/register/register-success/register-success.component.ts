import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register-success',
  templateUrl: './register-success.component.html',
  styleUrls: ['./register-success.component.css']
})
export class RegisterSuccessComponent implements OnInit {

  username: string | undefined;

  constructor(private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activeRoute.queryParamMap
    .subscribe(params => {
      if (params.has("username")) {
        this.username = params.get("username")!;
      } else {
        this.username = "";
      }
    });
  }

}
