import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { LogoComponent } from './shared/logo/logo.component';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { RegisterComponent } from './register/register/register.component';
import { IndexComponent } from './index/index/index.component';
import { CredentialsBackgroundComponent } from './shared/credentials-background/credentials-background.component';
import { RegisterFormComponent } from './register/register-form/register-form.component';
import { PasswordStrengthDirective } from './validator/password-strength.directive';
import { PasswordConfirmationDirective } from './validator/password-confirmation.directive';
import { RegisterSuccessComponent } from './register/register-success/register-success.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { AlbumTileComponent } from './shared/album-tile/album-tile.component';
import { MainViewComponent } from './main-view/main-view/main-view.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { DepositComponent } from './deposit/deposit/deposit.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoComponent,
    LoginFormComponent,
    RegisterComponent,
    IndexComponent,
    CredentialsBackgroundComponent,
    RegisterFormComponent,
    PasswordStrengthDirective,
    PasswordConfirmationDirective,
    RegisterSuccessComponent,
    PageNotFoundComponent,
    AlbumTileComponent,
    MainViewComponent,
    DepositComponent,
    AdminDashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatTabsModule,
    MatMenuModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
