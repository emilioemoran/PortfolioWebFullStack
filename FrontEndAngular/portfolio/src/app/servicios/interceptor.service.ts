import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpEvent,
  HttpHandler,
  HttpRequest,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AutenticacionService } from './autenticacion.service';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class InterceptorService implements HttpInterceptor {
  constructor(private autenticationService: AutenticacionService) {}
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    var currentUser = this.autenticationService.UsuarioAutenticado;
    if (currentUser && currentUser.accessToken) {
      req = req.clone({
        headers: req.headers.set(
          'Authorization',
          `Bearer ${currentUser.accessToken}`
        ),
      });
    }
    console.log(JSON.stringify(currentUser.accessToken));
    console.log(req?.headers);
    return next.handle(req).pipe(
      catchError((error) => {
        console.log('Returning caught observabl');
        return throwError(error);
      })
    );
  }
}
