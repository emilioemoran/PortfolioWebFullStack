import { Component, OnInit, Input } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css'],
})
export class EducacionComponent implements OnInit {
  @Input()
  persona!: {
    id: number;
    estudios: any;
  };
  modalData: any = {};

  defoultImage: String =
    'https://scientia1.files.wordpress.com/2014/02/universidad1.png';

  constructor(private portfolioService: PortfolioService) {}

  ngOnInit(): void {}

  saveNewEduModal(id: number) {
    const body = this.modalData;
    this.portfolioService.agregarEducacion(id, body).subscribe((data) => {
      console.log(JSON.stringify('data' + data));
      console.log('saliod');
      window.location.reload();
    });
  }

  deleteEducacion(id: number, educacion: any) {
    this.portfolioService.eliminarEducacion(id, educacion).subscribe(() => {
      window.location.reload();
    });
  }
}
