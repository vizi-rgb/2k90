import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, HostListener, OnInit } from '@angular/core';
import { AlbumTileComponent } from 'src/app/shared/album-tile/album-tile.component';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit {
  public userInfo = {
    username: "user",
    url: "assets/user-default.jpg"
  };

  public tileWidth: number;

  constructor(
    private breakpointObserver: BreakpointObserver
  ) {
    this.tileWidth = 300;
  }

  ngOnInit(): void {
    if (!this.isSmallScreen()) {
      this.tileWidth = this.calculateWidth();
    }
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
}
