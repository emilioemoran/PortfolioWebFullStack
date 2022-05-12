import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-singup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  form: FormGroup;
  error: any;
  constructor(
    private formBuilder: FormBuilder,
    private autentificationService: AutenticacionService,
    private route: Router
  ) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
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
    this.autentificationService.signUp(this.form.value).subscribe(
      (data) => {
        this.route.navigate(['/perfil', { id: data.id }]);
      },
      (err) => {
        this.error = JSON.stringify(err.error.message);
      }
    );
  }
}
