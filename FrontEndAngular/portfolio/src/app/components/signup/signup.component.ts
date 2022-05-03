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
    this.autentificationService.signUp(this.form.value).subscribe(
      (data) => {
        console.log(JSON.stringify('data' + data));
        this.route.navigate(['/perfil', { id: data.id }]);
      },
      (err) => {
        console.log(err);
        this.error = JSON.stringify(err.error.message);
      }
    );
  }
}
