import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { EncabezadoComponent } from './components/perfil/encabezado/encabezado.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { AcercaDeComponent } from './components/perfil/acerca-de/acerca-de.component';
import { ExperienciaComponent } from './components/perfil/experiencia/experiencia.component';
import { EducacionComponent } from './components/perfil/educacion/educacion.component';
import { HabilidadesComponent } from './components/perfil/habilidades/habilidades.component';
import { ProyectosComponent } from './components/perfil/proyectos/proyectos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './components/signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EncabezadoComponent,
    PerfilComponent,
    AcercaDeComponent,
    ExperienciaComponent,
    EducacionComponent,
    HabilidadesComponent,
    ProyectosComponent,
    SignupComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
