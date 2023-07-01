import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { LogoComponent } from './shared/logo/logo.component';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { RegisterComponent } from './register/register/register.component';
import { IndexComponent } from './index/index/index.component';
import { CredentialsBackgroundComponent } from './shared/credentials-background/credentials-background.component';
import { RegisterFormComponent } from './register/register-form/register-form.component';

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
