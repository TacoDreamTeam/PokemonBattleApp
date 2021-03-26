import { state } from '@angular/animations';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthorizeService } from '../services/authorize.service';
import { TokenService } from '../services/token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {

  constructor(
    private router: Router,
    private authService: AuthorizeService,
    private tokenService:TokenService
) { }
canActivate(
  next: ActivatedRouteSnapshot,
  state: RouterStateSnapshot): boolean {
  const url: string = state.url;

  return this.checkLogin(url);
}

checkLogin(url: string): boolean {
  if (this.tokenService.getRefreshToken()) {
    return true;
  }

  this.authService.redirectUrl = url;

  this.router.navigate(['/login']).then(_ => false);
  
  return false;
}


}
