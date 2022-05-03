import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class PortfolioService {
  url: String = 'http://localhost:8080/';
  constructor(private http: HttpClient) {}

  obtenerDatosPersona(id: number): Observable<any> {
    return this.http.get<any>(this.url + 'persona/' + id);
  }

  modificarDatosPersona(id: number, body: any): Observable<any> {
    return this.http.post<any>(this.url + 'persona/' + id, body);
  }
}
