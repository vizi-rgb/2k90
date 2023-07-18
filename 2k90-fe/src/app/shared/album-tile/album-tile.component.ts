import { Component, Input, OnInit, HostListener } from '@angular/core';
import { BreakpointObserver, BreakpointState, Breakpoints } from '@angular/cdk/layout';

@Component({
  selector: 'app-album-tile',
  templateUrl: './album-tile.component.html',
  styleUrls: ['./album-tile.component.css']
})
export class AlbumTileComponent implements OnInit {

  @Input()
  public fgPhotoUrl: string = "assets/astro.png";

  @Input()
  public bgPhotoUrl: string = "assets/views.png";

  @Input()
  public caption: string = "ASTROWORLD";

  @Input()
  public width: number = 300;

  @Input()
  public height: number = 120;

  @Input()
  public smSize: number = 100;

  public isSmallScreen: boolean;

  constructor(
    private breakpointObserver: BreakpointObserver
  ) {
    this.isSmallScreen = false;
  }

  ngOnInit(): void {
    this.isSmallScreen = this.breakpointObserver.isMatched(Breakpoints.XSmall);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.isSmallScreen = this.breakpointObserver.isMatched(Breakpoints.XSmall);
  }

}
