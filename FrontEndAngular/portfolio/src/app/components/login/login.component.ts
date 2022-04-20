import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validator, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private autentificationService: AutenticacionService,
    private route: Router
  ) {
    this.form = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      deviceInfo: this.formBuilder.group({
        deviceId: [''],
        deviceType: [''],
        notificationToken: [''],
      }),
    });
  }

  ngOnInit(): void {}

  get Email() {
    return this.form.get('email');
  }

  get Password() {
    return this.form.get('password');
  }

  onSubmit(event: Event) {
    event.preventDefault;
    this.autentificationService
      .iniciarSesion(this.form.value)
      .subscribe((data) => {
        console.log(JSON.stringify('data' + data));
        this.route.navigate(['perfil']);
      });
  }
}
