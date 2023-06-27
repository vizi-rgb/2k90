import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CredentialsBackgroundComponent } from './credentials-background.component';

describe('CredentialsBackgroundComponent', () => {
  let component: CredentialsBackgroundComponent;
  let fixture: ComponentFixture<CredentialsBackgroundComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CredentialsBackgroundComponent]
    });
    fixture = TestBed.createComponent(CredentialsBackgroundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
