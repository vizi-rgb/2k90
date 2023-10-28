import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register/register.component';
import { IndexComponent } from './index/index/index.component';
import { RegisterSuccessComponent } from './register/register-success/register-success.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MainViewComponent } from './main-view/main-view/main-view.component';
import { DepositComponent } from './deposit/deposit/deposit.component';
import {
  adminGuard,
  landingPageGuard,
  notLoggedInGuard,
} from './auth-guards.guard';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'register/success', component: RegisterSuccessComponent },
  {
    path: 'deposit',
    component: DepositComponent,
    canActivate: [notLoggedInGuard],
  },
  {
    path: 'home',
    component: MainViewComponent,
    canActivate: [notLoggedInGuard],
  },
  {
    path: 'dashboard',
    component: AdminDashboardComponent,
    canActivate: [adminGuard],
  },
  { path: '', component: IndexComponent, canActivate: [landingPageGuard] },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
