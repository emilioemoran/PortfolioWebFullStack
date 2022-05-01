import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class AutenticacionService {
  url = 'http://localhost:8080/api/auth';
  currentUserSubject: BehaviorSubject<any>;
  constructor(private httpClient: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<any>(
      JSON.parse(sessionStorage.getItem('currentUser') || '{}')
    );
  }

  iniciarSesion(credenciales: any): Observable<any> {
    return this.httpClient.post(this.url + '/login', credenciales).pipe(
      map((data) => {
        sessionStorage.setItem('currentUser', JSON.stringify(data));
        this.currentUserSubject.next(data);
        console.log(sessionStorage.getItem('currentUser'));
        return data;
        //comentario para ver
      })
    );
  }
  signUp(credenciales: any): Observable<any> {
    return this.httpClient.post(this.url + '/signup', credenciales).pipe(
      map((data) => {
        sessionStorage.setItem('currentUser', JSON.stringify(data));
        this.currentUserSubject.next(data);
        console.log(sessionStorage.getItem('currentUser'));
        return data;
        //comentario para ver
      })
    );
  }

  get UsuarioAutenticado() {
    return this.currentUserSubject.value;
  }
}
