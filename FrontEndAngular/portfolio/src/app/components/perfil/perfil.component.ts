import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
})
export class PerfilComponent implements OnInit {
  constructor(private portfolioService: PortfolioService) {
    this.portfolioService.obtenerDatosPersona(1).subscribe((data) => {
      console.log(JSON.stringify('data' + data));
    });
  }

  ngOnInit(): void {}
}
