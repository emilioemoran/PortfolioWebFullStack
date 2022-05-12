import { Component, OnInit, Input } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css'],
})
export class ProyectosComponent implements OnInit {
  @Input()
  persona!: {
    id: number;
    proyectos: any;
  };
  modalData: any = {};

  constructor(private portfolioService: PortfolioService) {}

  ngOnInit(): void {}

  saveNewProyModal(id: number) {
    this.portfolioService.agregarProyecto(id, this.modalData).subscribe(() => {
      window.location.reload();
    });
  }
  deleteProyModal(id: number, proyecto: any) {
    this.portfolioService.borrarProyecto(id, proyecto).subscribe(() => {
      window.location.reload();
    });
  }

  getRandomColor() {
    let letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    const styles = {
      'background-color': color,
    };
    return styles;
  }
}
