import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Quote {
  quote: string;
}

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  public quote: string | undefined;
  private apiUrl: string = "https://api.kanye.rest";

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.getKanyeSentence().subscribe((data: Quote) => this.quote = "\"".concat(data.quote, "\"") );
  }

  onIndexLogoClick() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth',
    });
  }

  getKanyeSentence(): Observable<Quote> {
    return this.http.get<Quote>(this.apiUrl);
  }
}
