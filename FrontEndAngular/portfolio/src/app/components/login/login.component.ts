import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validator, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rx';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  error: string = '';
  constructor(
    private formBuilder: FormBuilder,
    private autentificationService: AutenticacionService,
    private route: Router
  ) {
    this.form = this.formBuilder.group({
      /*  id: [''],
      username: [''],
      email: ['', [Validators.required, Validators.email]],
      accessToken: [''],
      tokenType: [''], */
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      /* email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
       deviceInfo: this.formBuilder.group({
        deviceId: [''],
        deviceType: [''],
        notificationToken: [''],
      }), */
    });
  }

  ngOnInit(): void {}

  get Email() {
    return this.form.get('email');
  }

  get Password() {
    return this.form.get('password');
  }
  get Username() {
    return this.form.get('username');
  }

  onSubmit(event: Event) {
    event.preventDefault;
    this.autentificationService.iniciarSesion(this.form.value).subscribe(
      (data) => {
        console.log(JSON.stringify('data' + data));
        this.route.navigate(['/perfil', { id: data.id }]);
      },
      (err) => {
        console.log(err);
        this.error = err;
      }
    );
  }
}
