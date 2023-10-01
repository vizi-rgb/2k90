import { inject } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, CanActivateFn, ROUTER_CONFIGURATION, Router, RouterStateSnapshot, createUrlTreeFromSnapshot } from '@angular/router';
import { AuthenticationService } from './services/authentication.service';

export const notLoggedInGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
) => {
  const isAnonymous: boolean = !inject(AuthenticationService).isAuthenticated;
  console.log(isAnonymous);

  if (isAnonymous) {
    return inject(Router).createUrlTree(["/", "login"]);
  }

  return true;
};

export const landingPageGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const isAnonymous: boolean = !inject(AuthenticationService).isAuthenticated;

  return isAnonymous ?
    true :
    inject(Router).createUrlTree(["/", "home"]);
};