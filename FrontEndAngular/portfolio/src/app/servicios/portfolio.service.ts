import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class PortfolioService {
  url: String = 'https://whispering-cove-31308.herokuapp.com/';
  constructor(private http: HttpClient) {}

  obtenerDatosPersona(id: number): Observable<any> {
    return this.http.get<any>(this.url + 'persona/' + id);
  }

  modificarDatosPersona(id: number, body: any): Observable<any> {
    return this.http.post<any>(
      this.url + 'persona/edit/encabezado/' + id,
      body
    );
  }

  modificarAcercaDePersona(id: number, body: any): Observable<any> {
    return this.http.post<any>(this.url + 'persona/edit/acercade/' + id, body);
  }

  agregarExperiencia(id: number, body: any): Observable<any> {
    return this.http.post<any>(
      this.url + 'persona/new/experiencia/' + id,
      body
    );
  }

  eliminarExperiencia(id: number, experiencia: any): Observable<any> {
    return this.http.post<any>(
      this.url + 'persona/delete/experiencia/' + id,
      experiencia
    );
  }

  agregarEducacion(id: number, body: any): Observable<any> {
    return this.http.post<any>(this.url + 'persona/new/educacion/' + id, body);
  }

  eliminarEducacion(id: number, educacion: any): Observable<any> {
    return this.http.post<any>(
      this.url + 'persona/delete/educacion/' + id,
      educacion
    );
  }

  agregarHabilidad(id: number, body: any): Observable<any> {
    return this.http.post<any>(this.url + 'persona/new/habilidad/' + id, body);
  }
  borrarHabilidad(id: number, body: any): Observable<any> {
    return this.http.post<any>(
      this.url + 'persona/delete/habilidad/' + id,
      body
    );
  }

  agregarProyecto(id: number, body: any): Observable<any> {
    return this.http.post<any>(this.url + 'persona/new/proyecto/' + id, body);
  }
  borrarProyecto(id: number, body: any): Observable<any> {
    return this.http.post<any>(
      this.url + 'persona/delete/proyecto/' + id,
      body
    );
  }
}
