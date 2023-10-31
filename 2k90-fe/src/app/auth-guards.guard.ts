import { inject } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivateFn,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { AuthenticationService } from './services/authentication.service';

export const notLoggedInGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
) => {
  const isAnonymous: boolean = !inject(AuthenticationService).isAuthenticated;
  console.log(isAnonymous);
  console.log('notLoggedInGuard');

  if (isAnonymous) {
    return inject(Router).createUrlTree(['/', 'login']);
  }

  return true;
};

export const landingPageGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
) => {
  const isAnonymous: boolean = !inject(AuthenticationService).isAuthenticated;
  console.log('landingPageGuard');

  return isAnonymous ? true : inject(Router).createUrlTree(['/', 'home']);
};

export const adminGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
) => {
  const userRole: string | undefined = inject(AuthenticationService).userValue
    ?.role;
  const isAdmin: boolean = userRole != undefined && userRole === 'ADMIN';
  console.log('adminGuard');

  return isAdmin;
};
