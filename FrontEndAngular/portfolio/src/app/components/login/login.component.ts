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
  error: string = '';
  constructor(
    private formBuilder: FormBuilder,
    private autentificationService: AutenticacionService,
    private route: Router
  ) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  ngOnInit(): void {}

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
