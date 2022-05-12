import { Component, OnInit, Input } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css'],
})
export class ExperienciaComponent implements OnInit {
  @Input()
  persona!: {
    id: number;
    experiencias: any;
  };

  modalData = {
    posicion: '',
    compania: '',
    imagen: '',
    fechaInicio: '',
    fechaFin: '',
  };

  defoultImage: String =
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjZxoun46uYwuj0W-JEfrEZ7aRawn4KPup_CFqzqj3LozS71yjaGWL08nN1KAYUv4TNg&usqp=CAU';

  constructor(private portfolioService: PortfolioService) {}

  ngOnInit(): void {}

  saveNewExpModal(id: number) {
    const body = this.modalData;
    this.portfolioService.agregarExperiencia(id, body).subscribe((data) => {
      console.log(JSON.stringify('data' + data));
      console.log('saliod');
      window.location.reload();
    });
  }

  deleteExperiencia(id: number, experiencia: any) {
    this.portfolioService.eliminarExperiencia(id, experiencia).subscribe(() => {
      window.location.reload();
    });
  }
}
