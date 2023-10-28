import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, HostListener, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { AlbumTileComponent } from 'src/app/shared/album-tile/album-tile.component';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit {
  public userInfo = {
    username: "",
    role: "",
    url: "assets/user-default.jpg"
  };

  public tileWidth: number;

  constructor(
    private breakpointObserver: BreakpointObserver,
    private authenticationService: AuthenticationService
  ) {
    this.tileWidth = 300;
    console.log({
      'authenticated': this.authenticationService.isAuthenticated,
      'value': this.authenticationService.userValue,
      'userInfo': this.userInfo
    });
  }

  ngOnInit(): void {
    if (!this.isSmallScreen()) {
      this.tileWidth = this.calculateWidth();
    }

    this.userInfo.username = this.authenticationService.userValue!.username;
    this.userInfo.role = this.authenticationService.userValue!.role;
    console.log(this.authenticationService.userValue?.email);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    if (!this.isSmallScreen()) {
      this.tileWidth = this.calculateWidth();
    }
  }

  private calculateWidth(): number {
      const materialTabWidth: number = window.innerWidth * 11 / 12.;

      const tileWidthRatio: number = 0.9;
      const calculatedWidth: number = materialTabWidth / 3 * tileWidthRatio;

      return calculatedWidth;
  }

  private isSmallScreen(): boolean {
    return this.breakpointObserver.isMatched(AlbumTileComponent.BREAKPOINTS);
  }

  public logout(): void {
    this.authenticationService.doLogout();
  }
}
