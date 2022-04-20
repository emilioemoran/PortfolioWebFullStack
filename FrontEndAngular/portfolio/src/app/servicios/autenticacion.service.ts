import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { JsonPipe } from '@angular/common';

@Injectable({ providedIn: 'root' })
export class AutenticacionService {
  url = '';
  currentUserSubject: BehaviorSubject<any>;
  constructor(private httpClient: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<any>(
      JSON.parse(sessionStorage.getItem('currentUser') || '{}')
    );
  }

  iniciarSesion(credenciales: any): Observable<any> {
    return this.httpClient.post(this.url, credenciales).pipe(
      map((data) => {
        sessionStorage.setItem('currentUser', JSON.stringify(data));
        return data;
      })
    );
  }
}
