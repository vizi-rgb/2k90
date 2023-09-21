import { inject } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, CanActivateFn, ROUTER_CONFIGURATION, Router, RouterStateSnapshot, createUrlTreeFromSnapshot } from '@angular/router';

export const notLoggedInGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const isAnonymous: boolean = true;

  if (isAnonymous) {
    return inject(Router).createUrlTree(["/", "login"]);
  }

  return false;
};

export const landingPageGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const isAnonymous: boolean = true;

  return isAnonymous ?
    true :
    inject(Router).createUrlTree(["/", "home"]);
};