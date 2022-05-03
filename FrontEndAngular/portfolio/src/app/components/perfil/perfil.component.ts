import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
})
export class PerfilComponent implements OnInit {
  miPortfolio: any = {};
  persona: any = {};
  constructor(
    private portfolioService: PortfolioService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const userId = Number(this.route.snapshot.paramMap.get('id'));
    this.portfolioService.obtenerDatosPersona(userId).subscribe((data) => {
      console.log(JSON.stringify('data' + data));
      this.miPortfolio.username = data.username;
      this.persona = data.persona;
    });
  }
}
